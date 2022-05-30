package com.example.snackdic;

public class MBTILibrary {
    private String mMBTIQuestion[]={
            "여행을 간다면 어떤 일이 있어도 그 지역의 맛집을 방문 해야합니다",//1
            "항상 먹을려는 양보다 요리 혹은 주문을 많이하여 음식이 남습니다",//2
            "눈 앞에 먹을 것이 있다면 아무리 배가 불러도 계속 주워먹습니다",//3
            "호기심 때문에 이상한 종류의 간식을 종종 도전하곤 합니다",//4
            "아무리 배고프더라도 아무거나 먹지 않고 제대로 된 음식을 먹습니다",//5
            "음식을 주문할 때 보통 모자란것 보다 넉넉한게 좋다",//6
            "음식을 섭취한 후에 포만감이 들지 않는다면 먹을거리를 찾아본다",//7
            "선택한 간식이 맛이 없다면 화가납니다",//8
            "음식을 먹었을때 재료에 뭐가 들어갔는지 잘맞추는 편이다",//9
            "먹는데 쓰는 돈은 아깝지 않다",//10
            "먹기위해 운동한다",//11
            "음식을 먹을 때 새로운 것 보다는 익숙한것이 좋다",//12
            "먹고싶은 음식이 여러 개라면 친구와 함께 주문하더라도 여러가지메뉴를 주문한다",//13
            "음식점을 찾을 때 가격은 크게 고려하지 않는다",//14
            "양이 많은 음식이라면 뭐든 좋다",//15
            ""
    };

    public String getQuestion(int a){
        String question = mMBTIQuestion[a];
        return question;
    }

    private String mSimple[]={
            "도전을 두려워하지 않으며 음식에 진심인 유형",
            "항상 새로운 것을 찾아 시도하거나 도전하는 성격의 방랑자형",
            "성격이 부드럽고 따뜻해 주변 사람들을 편안하게 해주는 유형",
            "이성적인 판단을 통하여 평소 음식 선택에도 실패가 잘 없는 유형",
            "늘 긍정적이며 에너지가 넘쳐 주위를 밝게 환기시켜주는 에너자이져형",
            "창의적이며 항상 웃음거리를 찾아다니는 유형",
            "베푸는 것을 좋아하며 혼자 있는 것보다 다같이 즐기는 것을 선호하는 유형",
            "어떠한 일이든 일어날 수 있다는 마음가짐으로 뭐든 그러려니 하는 유형",
            "자신의 직관을 믿고 그에 따른 성취에 큰 기쁨을 얻는 유형",
            "도전에 앞서 사전조사를 중시하며 근거를 바탕으로 행동하는 유형",
            "계획 세우는 것을 좋아하며 계획에 따라 행동하였을 때 성취감을 느끼는 유형",
            "한번 관심을 갖기 시작한 일은 반드시 성취 하려하는 유형",
            "과감한 결단을 잘 내리며 몸으로 직접 부딪히며 도전하는 것을 즐기는 유형",
            "작은 것 하나하나에 의미를 두며 여러 경험들을 얻는 것을 좋아하는 유형",
            "주변에서 뭐를 먹자 하든 항상 ok하며 잘먹는 모습이 보기 좋은 유형",
            "세상을 살아가는데 음식과 관련해 어떠한 것도 관심이 없는 유형",
            ""
    };

    public String getSimple(int a){
        String simple = mSimple[a];
        return simple;
    }

    public int getSen(int a, int b, int c, int d){
        int sen = 0;
        sen += (2 * a) - 8;
        sen += (2 * b) - 8;
        sen += (2 * c) - 8;
        sen += (2 * d) - 8;
        return sen;
    }
    public int getRic(int a, int b, int c, int d){
        int sen = 0;
        sen += (2 * a) - 8;
        sen += (2 * b) - 8;
        sen += (2 * c) - 8;
        sen += (2 * d) - 8;
        return sen;
    }
    public int getMuc(int a, int b, int c, int d){
        int sen = 0;
        sen += (2 * a) - 8;
        sen += (2 * b) - 8;
        sen += (2 * c) - 8;
        sen += (2 * d) - 8;
        return sen;
    }
    public int getCha(int a, int b, int c){
        int sen = 0;
        sen += (3 * a) - 12;
        if(a < 3) sen++;
        else if(a > 5) sen--;
        sen += 12 - (3 * b);
        if(b < 3) sen--;
        else if(b > 5) sen++;
        sen += 12 - (3 * c);
        if(c < 3) sen--;
        else if(c > 5) sen++;
        else if(c == 0) sen--;
        return sen;
    }

}
