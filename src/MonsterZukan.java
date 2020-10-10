import java.util.ArrayList;
import java.util.stream.*;

public class MonsterZukan {
    ArrayList<String> tempMonster = new ArrayList<String>();
    ArrayList<Double> tempMonsterRare = new ArrayList<Double>();

	//テスト用のモンスターデータを登録するメソッド
    public MonsterZukan() {
		tempMonster.add("イガキン");    tempMonsterRare.add(9.0);
		tempMonster.add("ナマチュウ");	tempMonsterRare.add(3.0);
		tempMonster.add("イノウエン");	tempMonsterRare.add(1.0);
		tempMonster.add("リョージィ");	tempMonsterRare.add(2.0);
		tempMonster.add("アキモトン");	tempMonsterRare.add(5.0);
		tempMonster.add("ゴージマ");	tempMonsterRare.add(4.0);
		tempMonster.add("チュウデン");	tempMonsterRare.add(6.0);
		tempMonster.add("ヅカホン");	tempMonsterRare.add(8.0);
		tempMonster.add("ニシムラー");	tempMonsterRare.add(7.0);
		tempMonster.add("サコーデン");	tempMonsterRare.add(2.0);
		tempMonster.add("ウッチー");	tempMonsterRare.add(5.0);
		tempMonster.add("ハヤッシー");	tempMonsterRare.add(14.0);
		tempMonster.add("キーチー");	tempMonsterRare.add(13.0);
		tempMonster.add("リョクン");	tempMonsterRare.add(11.0);
		tempMonster.add("デコポン");	tempMonsterRare.add(16.0);
		tempMonster.add("カミサン");	tempMonsterRare.add(15.0);
		tempMonster.add("シスイ");  	tempMonsterRare.add(11.0);
		tempMonster.add("ジョナ");	    tempMonsterRare.add(17.0);
		tempMonster.add("ギダギダ");	tempMonsterRare.add(12.0);
		tempMonster.add("ミッツー");	tempMonsterRare.add(18.0);
		tempMonster.add("ゾエサン");	tempMonsterRare.add(5.0);
		tempMonster.add("キタバー");	tempMonsterRare.add(23.0);

	}

    // public 
    // ここにgetterとsetterの代わりを追いとけばいいべ
}