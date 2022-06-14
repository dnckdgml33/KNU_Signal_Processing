package com.snack.snackdic;

public class TestVo {
    private int id;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //제너레이트 기능을 사용하여 생성자를 생성하면 편리하다.
    public TestVo(int id, String content) {
        this.id = id;
        this.content = content;
    }
}