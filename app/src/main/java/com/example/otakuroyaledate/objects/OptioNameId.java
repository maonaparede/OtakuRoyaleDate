package com.example.otakuroyaledate.objects;

public class OptioNameId {

    //Botão da cena (escolhas) , que ficam na recycler view da parte de cima
    //O nome representa o texto que vai no botão. O id é o id da próxima cena
    private String name;
    private String id;

    public OptioNameId(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
