

// public class ZooStation {
//     private int ball, fruits, egg;
//     static BallFruitsDistance BFD = new BallFruitsDistance();

//     //メインメソッド
//     public BallFruitsDistance Main() {
//         ZooStationStart();
//         return getItems();
//     }

//     public void ZooStationStart() {
//         FindMsg();
//         RandomValuesInit();
//         ResultMsg();
//     }

//     public BallFruitsDistance getItems() {
//         // BallFruits bf = new BallFruits();
//         BFE.Ball = this.ball;
//         BFE.Fruits = this.fruits;
//         // BFE.Distance = this.stitance;
//         return BFD;
//     }

//     //見つけたメッセージを出力
//     private static void FindMsg() {
//         System.out.println("ズーstationを見つけた！");
//     }

//     private void ResultMsg() {
//         System.out.println("ボールを"+this.ball+"個，"+"フルーツを"+this.fruits+"個"+"卵を"+this.egg+"個Getした！");
//     }

//     private int BallRandom() {
//         return (int)(Math.random()*3);
//     }

//     private int FruitsAndEggRandom() {
//         return (int)(Math.random()*2);
//     }

//     private void RandomValuesInit() {
//         this.ball = BallRandom();
//         this.fruits = FruitsAndEggRandom();
//         this.egg = FruitsAndEggRandom();
//     }
// }

// // public class BallFruits {
// //     int Ball;
// //     int Fruits;
// // }

// 			// this.balls=this.balls+b;
// 			// this.fruits=this.fruits+f;

// 		// IntStream.range(0, this.egg.size()).forEach(i -> {
// 		// 	if(this.egg.get(i)==true&&this.eggDistance.get(i)>=3){
// 		// 		System.out.println("卵が孵った！");
// 		// 		int m = (int)(this.monsterZukan.size()*Math.random());
// 		// 		System.out.println(this.monsterZukan.get(i)+"が産まれた！");
// 		// 		IntStream.range(0, userMonster.size()).filter(j -> this.userMonster.get(j) == null).findFirst().ifPresent(j -> {
// 		// 			this.userMonster.set(j, this.monsterZukan.get(m));
// 		// 		});
// 		// 		this.egg.set(i, false);
// 		// 		this.eggDistance.set(i, 0.0);
// 		// 	}		
// 		// });


//         /// userMonsterを使うものをまとめる「