package com.example.otakuroyaledate.scene_handler;

import android.content.Context;

import com.example.otakuroyaledate.objects.Scene;

public class SceneHandler {

    private Context context;
    private SceneMap sceneMap;

    public SceneHandler init(Context context){
        sceneMap = new SceneMap();
        sceneMap.transformJsonIntoRotas(context);
        this.context = context;
        return this;
    }

    public static void nextCene(String ceneId){

        if(!ceneId.trim().isEmpty() && ceneId != null) {
            try {
                RecyclerOptionHadler hadler = new RecyclerOptionHadler();
                Scene scene = SceneMap.getCeneMapById(ceneId);

                hadler.clearRecycler();

                if (scene != null){
                    new SceneBuilder().build()
                            .background(scene.getImgCene())
                            .dialogue(scene.getSaid())
                            .imagePersonagem(scene.getImgP())
                            .namePersonagem(scene.getNameP());

                hadler.addAllButtons(scene.getButton());
            }else{
                    throw new Exception("Cene ID: "+ ceneId + " not exist");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
