package net.jhopo.nonodroid;

import android.content.SharedPreferences;

public class Assign {
    public Assign(){

    }
    public void work(SharedPreferences Name_epic){
        int finished = Name_epic.getInt("Finished", 0);
        if(finished == 0) {
            SharedPreferences.Editor editor = Name_epic.edit();
            editor.putInt("Finished", 1);
            editor.putInt("科學小飛俠", 105);
            editor.putInt("無敵鐵金剛", 92);
            editor.apply(); //1972
            editor.putInt("網球甜心", 26);
            editor.putInt("魔投手", 46);
            editor.apply(); //1973
            editor.putInt("宇宙戰艦大和號", 26);
            editor.putInt("星星王子", 26);
            editor.putInt("蓋特機器人", 51);
            editor.putInt("小天使", 52);
            editor.putInt("雜牌拯救隊", 156);
            editor.putInt("金剛大魔神", 56);
            editor.apply(); //1974
            editor.putInt("救難小英雄", 61);
            editor.putInt("龍龍與忠狗", 52);
            editor.putInt("金剛戰神", 74);
            editor.putInt("一休和尚", 296);
            editor.apply(); //1975
            editor.putInt("萬里尋母", 52);
            editor.putInt("小甜甜", 115);
            editor.putInt("恐龍救生隊", 25);
            editor.putInt("無敵太空船", 36);
            editor.putInt("無敵龍捲風", 39);
            editor.putInt("超電磁機器人 孔巴德拉V", 54);
            editor.apply(); //1976
            editor.putInt("霹靂日光號", 56);
            editor.putInt("咪咪流浪記", 51);
            editor.putInt("波羅五號", 40);
            editor.putInt("浣熊拉斯卡爾", 52);
            editor.apply(); //1977
            editor.putInt("科學小飛俠II", 52);
            editor.putInt("金銀島 ", 26);
            editor.putInt("佩琳物語", 53);
            editor.putInt("太空突擊隊", 52);
            editor.putInt("宇宙戰艦大和號2", 26);
            editor.putInt("銀河鐵道999", 113);
            editor.putInt("未來少年柯南", 26);
            editor.putInt("新網球甜心", 25);
            editor.apply(); //1978
            editor.putInt("花仙子", 50);
            editor.putInt("科學小飛俠F", 48);
            editor.putInt("凡爾賽玫瑰", 40);
            editor.putInt("巨獸王", 47);
            editor.putInt("機動戰士鋼彈", 43);
            editor.putInt("清秀佳人", 50);
            editor.putInt("黑豹傳奇", 73);
            editor.apply(); //1979
            editor.putInt("傳說巨神伊甸王", 39);
            editor.putInt("大白鯨", 26);
            editor.putInt("宇宙戰艦大和號III", 25);
            editor.putInt("小戰士", 52);
            editor.putInt("怪物王子", 94);
            editor.putInt("小拳王第二部", 47);
            editor.putInt("湯姆歷險記 ", 49);
            editor.putInt("神勇戰士", 50);
            editor.putInt("鐵超人", 51);
            editor.apply(); //1980
            editor.putInt("怪博士與機器娃娃", 243);
            editor.putInt("六神合體", 64);
            editor.putInt("新魯賓遜漂流記", 50);
            editor.putInt("忍者哈特利", 694);
            editor.putInt("戰國魔神豪將軍", 26);
            editor.putInt("無敵小戰士", 52);
            editor.putInt("福星小子", 195);
            editor.putInt("百獸王", 52);
            editor.apply(); //1981
            editor.putInt("南方彩虹的露西", 50);
            editor.putInt("超時空要塞", 36);
            editor.apply(); //1982
            editor.putInt("貓眼", 73);
            editor.putInt("裝甲騎兵", 52);
            editor.putInt("咪姆", 127);
            editor.putInt("魔法小天使", 52);
            editor.putInt("足球小將", 128);
            editor.putInt("金肉人", 137);
            editor.putInt("阿爾卑斯物語 我的安妮特", 48);
            editor.apply(); //1983
            editor.putInt("北斗神拳", 109);
            editor.putInt("宇宙奇兵", 51);
            editor.putInt("牧場上的少女卡特莉", 49);
            editor.putInt("玻璃假面", 23);
            editor.apply(); //1984
            editor.putInt("TOUCH 鄰家女孩", 101);
            editor.putInt("六三四之劍", 72);
            editor.putInt("莎拉公主", 46);
            editor.putInt("搞怪拍檔", 24);
            editor.putInt("機動戰士Z 鋼彈", 50);
            editor.putInt("銀河戰士", 25);
            editor.apply(); //1985
            editor.putInt("七龍珠", 153);
            editor.putInt("愛少女波麗安娜物語", 51);
            editor.putInt("機動戰士鋼彈 ZZ", 47);
            editor.putInt("機器勇士", 44);
            editor.putInt("相聚一刻", 96);
            editor.putInt("聖鬥士星矢", 114);
            editor.putInt("甜蜜公主", 51);
            editor.apply(); //1986
            editor.putInt("城市獵人", 336);
            editor.putInt("北斗神拳2", 43);
            editor.putInt("天威勇士", 31);
            editor.putInt("小婦人", 48);
            editor.putInt("古靈精怪", 48);
            editor.putInt("聖魔大戰", 75);
            editor.putInt("肥牛牛布斯", 53);
            editor.putInt("變形金剛：頭領戰士", 35);
            editor.putInt("超能力魔美", 119);
            editor.putInt("格林名作劇場", 24);
            editor.apply(); //1987
            editor.putInt("奇天烈大百科", 331);
            editor.putInt("小公子西迪", 43);
            editor.putInt("變形金剛：超神戰士軍", 42);
            editor.putInt("超音戰士", 35);
            editor.putInt("魁男塾", 34);
            editor.putInt("魔神英雄傳", 45);
            editor.putInt("勇往直前", 6);
            editor.putInt("銀河英雄傳說", 26);
            editor.putInt("美味大挑戰", 136);
            editor.apply(); //1988
            editor.putInt("衝鋒四驅郎", 25);
            editor.putInt("亂馬1/2", 18);
            editor.putInt("七龍珠Z", 291);
            editor.putInt("以柔克剛", 124);
            editor.putInt("大耳鼠", 112);
            editor.putInt("天空戰記", 38);
            editor.putInt("彼得潘的冒險", 41);
            editor.putInt("森林大帝", 52);
            editor.putInt("機動警察", 47);
            editor.putInt("變形金剛Ｖ", 44);
            editor.putInt("魔動王", 41);
            editor.putInt("桃太郎傳說", 51);
            editor.apply(); //1989
            editor.putInt("七海遊龍", 45);
            editor.putInt("NG騎士檸檬汽水&40", 38);
            editor.putInt("海底兩萬哩", 39);
            editor.putInt("長腿叔叔", 40);
            editor.putInt("櫻桃小丸子第一期", 142);
            editor.putInt("至尊勇者", 50);
            editor.putInt("魔神英雄傳2", 46);
            editor.putInt("羅賓漢大冒險", 58);
            editor.putInt("功夫貓黨", 54);
            editor.putInt("勇者凱撒", 48);
            editor.putInt("小俏妞", 43);
            editor.putInt("超級劍豪傳", 50);
            editor.putInt("三眼神童", 48);
            editor.apply(); //1990
            editor.putInt("21衛門", 39);
            editor.putInt("城市獵人2", 63);
            editor.putInt("勇者鬥惡龍 達伊的大冒險", 46);
            editor.putInt("絕對無敵", 51);
            editor.putInt("閃電霹靂車", 37);
            editor.putInt("太陽勇者", 48);
            editor.putInt("真善美", 40);
            editor.putInt("金肉人第二期", 46);
            editor.putInt("金魚注意報", 108);
            editor.putInt("鬥球兒彈平", 47);
            editor.putInt("百戰小奇兵", 47);
            editor.putInt("三國志", 60);
            editor.putInt("我與我 兩個綠蒂", 29);
            editor.apply(); //1991
            editor.putInt("勇者傳說", 46);
            editor.putInt("南國少年奇小邪", 56);
            editor.putInt("俏皮小花仙", 50);
            editor.putInt("元氣小子", 47);
            editor.putInt("草原小天使", 40);
            editor.putInt("妙廚老爹", 141);
            editor.putInt("宇宙騎士利刃", 49);
            editor.putInt("幽遊白書", 112);
            editor.putInt("美少女戰士", 46);
            editor.putInt("橘子繪日記", 31);
            editor.putInt("超時空保姆", 50);
            editor.putInt("超電動機器人 鐵人28號FX", 47);
            editor.putInt("電影少女", 6);
            editor.putInt("超時空要塞II：再愛一次", 6);
            editor.putInt("東京巴比倫", 3);
            editor.apply(); //1992
            editor.putInt("奇蹟女孩", 51);
            editor.putInt("足球風雲", 58);
            editor.putInt("GS美神 極樂大作戰", 45);
            editor.putInt("為食龍少爺", 51);
            editor.putInt("叮噹貓", 170);
            editor.putInt("可愛巧虎島", 726);
            editor.putInt("新小婦人", 40);
            editor.putInt("機動戰士V 鋼彈", 51);
            editor.putInt("灌籃高手", 101);
            editor.putInt("熱血最強", 51);
            editor.putInt("美少女戰士R", 43);
            editor.putInt("淘氣貓 喵喵三丁目", 35);
            editor.putInt("疾風戰士", 52);
            editor.putInt("城市風雲兒", 52);
            editor.putInt("家有賤狗", 40);
            editor.putInt("無責任艦長", 26);
            editor.apply(); //1993
            editor.putInt("碧奇魂", 26);
            editor.putInt("DNA2", 12);
            editor.putInt("七海的堤可", 39);
            editor.putInt("咕嚕咕嚕魔法陣", 45);
            editor.putInt("小紅帽恰恰", 74);
            editor.putInt("橘子醬男孩", 76);
            editor.putInt("機動武鬥傳G鋼彈", 49);
            editor.putInt("美少女戰士S", 38);
            editor.putInt("幸運超人", 50);
            editor.putInt("超時空要塞7", 49);
            editor.putInt("足球小將J", 47);
            editor.putInt("飛虎奇兵", 49);
            editor.putInt("魔法騎士雷亞斯", 49);
            editor.putInt("銀河戰國群雄傳", 52);
            editor.putInt("美少女戰鬥隊", 13);
            editor.putInt("Macross Plus", 4);
            editor.putInt("非常偶像Key", 15);
            editor.putInt("飛天少女豬", 51);
            editor.apply(); //1994
            editor.putInt("芳鄰物語", 50);
            editor.putInt("H2", 39);
            editor.putInt("鬼神童子ZENKI", 51);
            editor.putInt("秀逗魔導士", 26);
            editor.putInt("十二生肖 爆烈戰士", 39);
            editor.putInt("去吧稻中桌球社", 26);
            editor.putInt("夢幻遊戲", 52);
            editor.putInt("天地無用", 26);
            editor.putInt("小紅豆 ", 117);
            editor.putInt("怪盜Saint Tail", 43);
            editor.putInt("愛天使傳說", 51);
            editor.putInt("新世紀福音戰士", 26);
            editor.putInt("新機動戰記鋼彈W", 49);
            editor.putInt("羅密歐的藍天", 33);
            editor.putInt("美少女戰士SuperS", 39);
            editor.putInt("黃金勇者", 48);
            editor.putInt("爆走獵人", 26);
            editor.putInt("神秘的世界", 13);
            editor.apply(); //1995
            editor.putInt("烏龍派出所", 386);
            editor.putInt("鋼鐵神兵", 25);
            editor.putInt("玩偶遊戲", 102);
            editor.putInt("秀逗魔導士NEXT", 26);
            editor.putInt("逮捕令 ", 51);
            editor.putInt("VS騎士檸檬汽水&40炎", 26);
            editor.putInt("美少女戰士Sailor Stars", 34);
            editor.putInt("七龍珠GT", 64);
            editor.putInt("名犬萊西", 26);
            editor.putInt("天才寶貝", 35);
            editor.putInt("奧運高手", 30);
            editor.putInt("機動戰艦", 26);
            editor.putInt("機動新世紀鋼彈 X", 39);
            editor.putInt("機械女神", 25);
            editor.putInt("水色時代", 47);
            editor.putInt("花樣男子", 51);
            editor.putInt("神劍闖江湖", 94);
            editor.putInt("無家可歸的孩子蕾米", 26);
            editor.putInt("閃電怪馬", 61);
            editor.putInt("爆走兄弟", 153);
            editor.putInt("聖天空戰記", 26);
            editor.putInt("靈異教師神眉", 48);
            editor.putInt("魔法提琴手", 25);
            editor.putInt("妖精狩獵者", 12);
            editor.putInt("機動戰士鋼彈第08MS小隊", 12);
            editor.apply(); //1996
            editor.putInt("大運動會", 26);
            editor.putInt("CLAMP學園偵探團", 26);
            editor.putInt("妖精狩獵者II", 12);
            editor.putInt("靈異獵人", 12);
            editor.putInt("新怪博士機器娃娃", 74);
            editor.putInt("神奇寶貝", 276);
            editor.putInt("少女革命", 39);
            editor.putInt("中華一番", 52);
            editor.putInt("秀逗魔導士TRY", 26);
            editor.putInt("勇者王GaoGaiGar", 12);
            editor.putInt("蠟筆小王國", 70);
            editor.putInt("新天地無用", 26);
            editor.putInt("天才小魚郎", 25);
            editor.putInt("烙印勇士", 25);
            editor.putInt("金田一少年之事件簿", 148);
            editor.putInt("超魔神英雄傳", 51);
            editor.putInt("櫻花通信", 12);
            editor.putInt("Macross Dynamite 7", 4);
            editor.putInt("龍機傳承", 3);
            editor.apply(); //1997
            editor.putInt("頭文字D First Stage", 26);
            editor.putInt("槍神", 26);
            editor.putInt("白色十字架", 13);
            editor.putInt("婆娑羅", 13);
            editor.putInt("時空偵探", 39);
            editor.putInt("他和她的事情", 26);
            editor.putInt("星際牛仔", 26);
            editor.putInt("危險調查員", 39);
            editor.putInt("羅德斯島戰記-英雄騎士傳", 27);
            editor.putInt("守護月天", 22);
            editor.putInt("幸運女神", 22);
            editor.putInt("夢幻拉拉", 26);
            editor.putInt("失落的宇宙", 26);
            editor.putInt("女棒甲子園", 26);
            editor.putInt("快傑蒸汽偵探團", 26);
            editor.putInt("機動神腦", 26);
            editor.putInt("機械女神", 25);
            editor.putInt("炸彈人 彈珠人爆外傳", 48);
            editor.putInt("玲音", 13);
            editor.putInt("庫洛魔法使", 70);
            editor.putInt("秋葉原電腦組", 26);
            editor.putInt("遊戲王", 27);
            editor.putInt("魔法陣都市", 26);
            editor.putInt("魔術士歐菲", 24);
            editor.putInt("麗佳公主", 52);
            editor.putInt("時空轉抄納斯卡", 12);
            editor.putInt("青之6號", 4);
            editor.putInt("餓沙羅鬼", 25);
            editor.apply(); //1998
            editor.putInt("頭文字D Second Stage", 13);
            editor.putInt("網路安琪兒", 26);
            editor.putInt("數碼寶貝大冒險", 54);
            editor.putInt("麻辣教師GTO", 43);
            editor.putInt("獵人", 62);
            editor.putInt("下級生", 13);
            editor.putInt("小魔女DoReMi第一部", 51);
            editor.putInt("恐怖寵物店", 4);
            editor.putInt("Di Gi Charat", 16);
            editor.putInt("傀儡師左近", 26);
            editor.putInt("星界的紋章", 13);
            editor.putInt("逮捕令 Special", 21);
            editor.putInt("To Heart", 13);
            editor.putInt("∀鋼彈", 50);
            editor.putInt("天使不設防", 26);
            editor.putInt("無限的未知", 26);
            editor.putInt("神風怪盜貞德", 44);
            editor.putInt("蟲孽", 26);
            editor.putInt("霹靂酷樂貓", 66);
            editor.putInt("迷糊女戰士", 25);
            editor.putInt("魔裝機神", 26);
            editor.putInt("封神演義", 26);
            editor.putInt("十兵衛", 13);
            editor.putInt("鋼鐵天使", 24);
            editor.putInt("機獸新世紀ZOIDS", 67);
            editor.putInt("格鬥小霸王", 26);
            editor.apply(); //1999
            editor.putInt("疾走王子Alternative", 12);
            editor.putInt("無彩限的幻影世界", 13);
            editor.putInt("壽司警察", 13);
            editor.putInt("春&夏事件簿 春太與千夏的青春", 12);
            editor.putInt("命運九重奏", 12);
            editor.putInt("少女們向荒野進發", 12);
            editor.putInt("只有我不存在的城市", 12);
            editor.putInt("大叔與棉花糖", 12);
            editor.putInt("Active Raid－機動強襲室第八係－", 12);
            editor.putInt("夢幻之星Online2 The Animation", 12);
            editor.putInt("粗點心戰爭", 12);
            editor.putInt("神聖之門", 12);
            editor.putInt("百無禁忌！女高中生私房話", 12);
            editor.putInt("石膏男團", 12);
            editor.putInt("旅街晚間秀", 4);
            editor.putInt("紅殼的潘朵拉", 12);
            editor.putInt("從前有座靈劍山", 12);
            editor.putInt("GATE 奇幻自衛隊第二期", 12);
            editor.putInt("昭和元祿落語心中", 13);
            editor.putInt("舞武器·舞亂伎", 12);
            editor.putInt("幸運邏輯", 12);
            editor.putInt("無頭騎士異聞錄 DuRaRaRa!!×2 結", 12);
            editor.putInt("魔法護士小麥R", 12);
            editor.putInt("房東妹子青春期", 12);
            editor.putInt("Dimension W", 12);
            editor.putInt("灰與幻想的格林姆迦爾", 12);
            editor.putInt("黑之宣告", 12);
            editor.putInt("最弱無敗神裝機龍", 12);
            editor.putInt("暗芝居第三期", 13);
            editor.putInt("魔法少女什麼的已經夠了啦", 12);
            editor.putInt("蒼之彼方的四重奏", 12);
            editor.putInt("為美好的世界獻上祝福", 10);
            editor.putInt("亞人", 13);
            editor.putInt("血型小將ABO第四期", 12);
            editor.putInt("赤髮白雪姬第二季", 12);
            editor.putInt("庭球社第七期", 12);
            editor.putInt("這名男子，從事魔法工作", 4);
            editor.putInt("她與她的貓 -Everything Flows", 4);
            editor.apply(); //2016-1
            //editor.putInt("", );
        }
    }
}
