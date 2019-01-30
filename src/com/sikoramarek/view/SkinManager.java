package com.sikoramarek.view;

import com.sikoramarek.common.PlayerAction;
import com.sikoramarek.common.ResourceLoader;
import com.sikoramarek.model.CharacterModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.*;

public class SkinManager extends ImageView {

    public SkinManager(CharacterModel model){
        this.model = model;
    }

    private CharacterModel model;

    public int offset;

    public Image currentImage;

    HashMap<PlayerAction, ArrayList> skinMap = new HashMap();
    List<Image> skins = new LinkedList<Image>();

    int currentSkin = 0;

    void loadSkinMap(PlayerAction action, String patch){
       ArrayList<String> list = ResourceLoader.load("./src/com/sikoramarek/view/resources/"+patch);
       Collections.sort(list);
       ArrayList<Image> imageArrayList = new ArrayList<>();
       for (String image: list){
           try {
               imageArrayList.add(new Image(patch+"/"+image));
           }catch (IllegalArgumentException e){
               System.out.println(e.getMessage());
               System.out.println(patch+"/"+image);
           }
       }
       skinMap.put(action, imageArrayList);
    }


    public void update(){
        this.setX(model.getX_pos());
        this.setY(model.getY_pos()+offset);
        skins = skinMap.get(model.action);
        if (currentSkin < skins.size() - 1){
            currentSkin += 1;
        }else{
            currentSkin = 0;}
        currentImage = skins.get(currentSkin);
        this.setImage(currentImage);
    }

}
