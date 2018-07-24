package com.pipon.mergeemall.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.pipon.mergeemall.Game;
import com.pipon.mergeemall.math.Vector3i;

public class GameScene {
    private PerspectiveCamera cam;
    //private CameraInputController camController;
    private ModelBatch modelBatch;
    private AssetManager assets;
    private Array<ModelInstance> instances = new Array<ModelInstance>();
    private Environment environment;
    private boolean loading;
    private Model model;
    private TileView_old tileView;

    public void create() {
        modelBatch = new ModelBatch();
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(0.0f, 90.0f, 0.0f);
        cam.lookAt(0,0,0);
        cam.near = 1f;
        cam.far = 300f;
        cam.update();

       /* camController = new CameraInputController(cam);
        Gdx.input.setInputProcessor(camController);*/

        assets = new AssetManager();
        assets.load("tile.g3db", Model.class);
        loading = true;
    }

    public void render() {

        if (loading && assets.update()) {
            model = assets.get("tile.g3db", Model.class);
            tileView = new TileView_old(model, instances, 0.0f, 0.0f, 3);
            loading = false;
        }

        if(tileView != null)
            tileView.render();

        //camController.update();

        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        System.out.println(Gdx.graphics.getWidth()+", "+Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        modelBatch.begin(cam);
        modelBatch.render(instances, environment);
        modelBatch.end();
    }

    public void dispose() {
        modelBatch.dispose();
        instances.clear();
        assets.dispose();
    }

}
