package com.example.snackdic;

public class TestVo {
    private String id;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //제너레이트 기능을 사용하여 생성자를 생성하면 편리하다.
    public TestVo(String id, String content) {
        this.id = id;
        this.content = content;
    }
}