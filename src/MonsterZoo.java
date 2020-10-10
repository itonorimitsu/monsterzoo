/// 出力の部分はメソッド化でいいのでは？
import java.util.ArrayList;
import java.util.stream.*;


public class MonsterZoo {
	static Move move = new Move();
	
	public int flg1;

	//呼び出すと1km distanceが増える
	void Main(){
		move.MoveMain();
		this.MakeFlag();
		this.BranchFlag();
	}

	private void MakeFlag() {
		//0,1の場合はズーstation，7~9の場合はモンスター
		this.flg1 = (int)(Math.random()*10);
	}

	private void BranchFlag() {
		if (this.flg1 <= 1) {
			move.ZooStationStart();
		} else if (this.flg1 >= 7) {
			move.CaptureMain();
		}
		move.EggStream();
	}

	public void MoveMsg() {
		move.MoveMsg();
	}

	public void BallLostMsg() {
		move.BallLostMsg();
	}

	public int BallCount() {
		return move.BallCount();
	}

}