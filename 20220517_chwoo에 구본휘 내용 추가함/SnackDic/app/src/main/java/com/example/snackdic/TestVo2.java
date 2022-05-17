package com.example.snackdic;

public class TestVo2 {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //제너레이트 기능을 사용하여 생성자를 생성하면 편리하다.
    public TestVo2( String content) {
        this.content = content;
    }
}
