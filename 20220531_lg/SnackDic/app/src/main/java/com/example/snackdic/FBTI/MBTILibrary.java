package com.example.snackdic.FBTI;

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
        if(a < 0) return "0";
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
            "자신의 느낌을 믿고 감각에 따라 행동하는 유형",
            "도전에 앞서 사전조사를 중시하며 근거를 바탕으로 행동하는 유형",
            "계획 세우는 것을 좋아하며 계획에 따라 행동하였을 때 성취감을 느끼는 유형",
            "어떠한 상황에서도 더 좋은 방향으로 나아가려고 하며 한번 관심을 갖기 시작한 일은 반드시 성취 하려하는 유형",
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

    private String mDetail[]={
            " 모험가형은 어떤 음식을 먹게 되든지 진심을 다하는 편입니다. 진심이라는 것은 돈, 맛, 도전정신, 식욕 모두를 아우르는 말이라고 할 수 있습니다. 또한 가슴을 뛰게 하는 것이, 혹은 마음속 깊은 바람을 충족시키고자 하는 열망이 있다면 이 꿈을 위해, 삶이라는 모험을 위해 기꺼이 바보가 될 준비가 되어있습니다.",
            " 여행가형은 자유로운 영혼의 소유자입니다. 매력적이며 독립적인 성격의 소유자로 활발하면서도 인정이 많은 유형입니다. 여기저기 돌아다니며 사람을 만나는 것을 좋아하며 인생에 슬픈 일이 있을 때, 혹은 힘든 일이 있을 때 새로운 공간에서 새로운 사람을 만나고 처음 맛보는 음식으로 인하여 기분을 풀기도 합니다.",
            " 연예인형은 사교적인 이타주의자로도 말할 수 있으며 주변사람들에 관심이 많고 누구든 따뜻하게 대해주어 사람들이 믿고 의지할 수 있는 그런 유형의 사람입니다. 겉보기엔 튼튼하고 단단한 사람이지만 자신을 향한 좋지 않은 말이 들린다면 쉽게 상처받고 혼자 앓고 있습니다. 때로는 겁내지 않고 주변에 기대는 것도 이를 해결하는 한가지 방법입니다.",
            " 요리사형은 매사에 꼼꼼하며 성실한 사람입니다. 하는 모든 일에 적극적이고 실수를 잘 하지 않으며 완벽을 추구합니다. 다만 지금까지 해온 일의 결과가 좋지 못할 경우 그만큼 실망일 더 클 수밖에 없습니다. 항상 열심히 달리는 것도 좋지만 때로는 느긋하게 주변을 둘러보는 여유를 갖는 것도 좋습니다.",
            " 이들은 친구나 다른 이들과 어울릴 시 쇼맨십에 찬 모습을 보이기도 하는데, 썰렁한 유머를 던져 주의를 집중시키기도 하는 이들은 그들이 가는 곳곳마다 시끌벅적한 파티를 연상케 합니다. 매우 사교적인 성향의 이들은 단순한 것을 좋아하며, 좋은 사람들과 어울려 즐거운 시간을 갖는 것보다 세상에 더 큰 즐거움은 없다고 여깁니다.",
            " 제리형은 즐거운 것을 좋아하는 사람들입니다. 맛에는 연연하지 않는 편이며 특이한 음식을 먹을 때 재미가 있는 요소가 있으면 맛이 없어도 기분 좋게 음식을 먹습니다. 게다가 양을 그렇게 많이 먹는 편이 아니기 때문에 더욱 그렇다고 할 수 있습니다.",
            " 씨름선수형은 다른 사람들과 어울려서 음식을 함께 먹는 것을 즐기는 편입니다. 다 함께 먹는 것을 선호하며 돈에는 크게 연연하지 않습니다. 어떤 음식이든 크게 신경을 쓰지는 않지만 새로운 음식점을 찾지 않으며, 평소 애용하는 단골가게가 많은 편입니다.",
            " 스님 유형은 항상 느긋하고 여유로운 마음을 가지고 살아가는 사람입니다. 개인의 이득을 취하기 위해 목소리를 높이지는 않지만, 그렇다고 부당한 일에도 마냥 아무 말 하지 않고 있는 것은 아닙니다. 나긋나긋한 목소리 뒤에는 강직함이 숨어있으며, 의견을 강력하게 피력할 줄 알며 옳다고 생각되는 일에는 지칠 줄 모르고 투쟁합니다.",
            " 투우사형은 평소 감각이 좋으며 본능에 충실한 유형입니다. 도전하기에 없어 근거가 불충분하더라도 감각이 도전을 시작하는 근거가 됩니다. 하지만 이처럼 본능에 충실하기 때문에 도전에 있어서는 때때로 실패도 있지만 한때의 아쉬움으로 남겨두고 금방 또 다른 시작을 하는 모습을 보입니다.",
            " 미식가형은 정말로 까다로운 사람입니다. 뭔가를 먹기 위해서는 계획적으로 행동하는 것을 좋아하며, 그에 대한 정당한 보상을 얻길 원하지요. 예를 들면 뭔가를 먹더라도 가성비가 좋은 것을 찾거나, 다른 사람들의 평가를 보고 철저하게 검증된 것을 먹는 것을 좋아합니다. 즉, 무언가에 도전하는 것은 나쁘지 않다고 생각하나 그것을 실행하기 위해서 그에 대한 사전조사를 소홀히 하지 않습니다.",
            " 기본적으로 계획 세우는 것을 좋아하며, 계획을 세웠다면 반드시 이행하여야 하는 성격입니다. 색다른 흥미거리 혹은 관심거리가 생기면 재빠르게 계획을 변경하기도 하는데 이때에도 원래 계획하였던 일은 그만 두는 것이 아니라 새로 생긴 관심거리와 함께 실행하는 실천력을 가지고 있습니다. 또한 시간약속에는 예민하며 주로 약속시간보다 10분가량 일찍 도착하는 성향이 있습니다.",
            " 음유시인형은 어떠한 경우에도 희망을 잃지 않으며 끊임없이 노력하는 사람들입니다. 늘 밝은 성격의 사람들이며 하고 싶은 걸 꾸준히 열심히 하다 보면, 결국엔 잘하는 날이 올 것이라 믿고 살아갑니다.",
            " 격투가형은 앉아서 말로 하는 논의가 아닌 직접 나가 몸으로 부딪히는 것을 선호하는 사람들입니다. 행동이 먼저 앞서다 보니 때로는 실수를 범하기도 하지만 이들은 단순히 사태가 나아지길 기다리는 것 보다 직접 나가 몸으로 부딪혀 문제를 해결해 나갑니다. 그래서 위험을 수반하는 행동을 자주 하는 경향이 있지만 이를 삶의 다양한 맛과 열정으로 느끼며 이러한 자극들을 즐깁니다.",
            " 예술가형 사람은 지금까지 겪은 모든 일을 바탕으로 본인만의 이념을 만들었으며, 이 이념을 바탕으로 행동하는 사람입니다. 이들은 논쟁을 벌일 때 타인의 논리를 보다 잘 이해하고 있고, 상대편과 자신의 관점의 차이도 정확히 꿰뚫어 봅니다. 이를 통해 수많은 이념들을 다양한 각도에서 바라보며 더 옳은 해답을 찾아갑니다.",
            " 남고생형은 예스맨입니다. 나쁘게 말하면 줏대가 없고 좋게 말하면 주변 상황에 잘 녹아 든다고 할 수 있지요. 평소 주변 분위기에 잘 휩쓸리며 어떤 모임이든 항상 참여해 있습니다. 또한 남고생형은 의외로 섬세한 면이 있어 주변 인물들의 이야기를 관심 있게 들어주며 세세한 사항마저 기억하는 경향이 있습니다. 이러한 성격으로 주변에 은근하게 선한 영향을 많이 끼치고 있습니다.",
            " 자연인형은 ‘음식’에 관해서는 이미 득도하여 해탈하였습니다. 어떤 것을 먹는지도 관심이 없고, 주변 사람이 뭘 먹자고 해도 그냥 그러려니 하며 배고프면 먹고 그렇지 않다면 굳이 먹지 않습니다. 음식은 단순이 살아가기 위해 먹는 것 그 이상도 그 이하도 아닙니다. 먹는 것에 크게 관심이 없는 만큼 다른 취미를 갖고 있을 가능성이 높습니다.",
            ""
    };

    public String getDetail(int a){
        String detail = mDetail[a];
        return detail;
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