package game;

import java.util.Scanner;

public class Game {

	public static void main(String args[]) {
		
		Scanner scan= new Scanner(System.in);
		//플레이어 정보 입력
		System.out.println("플레이어의 정보를 입력해주세요.");
		
		System.out.println("플레이어의 이름을 입력해보세요.");
		String P_Name= scan.nextLine();

		System.out.println("플레이어의 체력을 입력해보세요.");
		int P_hp= scan.nextInt();
		scan.nextLine();
		
		System.out.println("플레이어의 공격력을 입력해보세요.");
		int P_damage= scan.nextInt();
		scan.nextLine();
		
		//플레이어 무기 정보 입력
		System.out.println("플레이어 무기의 정보를 입력해주세요.");
		
		System.out.println("플레이어 무기의 이름을 입력해보세요.");
		String PW_Name= scan.nextLine();

		System.out.println("플레이어 무기의 종류를 입력해보세요.");
		String PW_category= scan.nextLine();
		
		System.out.println("플레이어 무기의 공격력을 입력해보세요.");
		int PW_damage= scan.nextInt();
		scan.nextLine();
		
		// 입력받은값 대입
		Player player=new Player(P_Name,P_hp,P_damage,PW_Name,PW_category,PW_damage);
		System.out.println("\n--------------------------------------------------------------------------------------------------------------------------");
		
		
		//몬스터 정보 입력
		System.out.println("몬스터의 정보를 입력해주세요.");
		
		System.out.println("몬스터의 이름을 입력해보세요.");
		String M_Name= scan.nextLine();

		System.out.println("몬스터의 체력을 입력해보세요.");
		int M_hp= scan.nextInt();
		scan.nextLine();
				
		System.out.println("몬스터의 공격력을 입력해보세요.");
		int M_damage= scan.nextInt();
		scan.nextLine();
				
		//몬스터 무기 정보 입력
		System.out.println("몬스터 무기의 종류를 입력해주세요.");
			
		System.out.println("몬스터 무기의 이름을 입력해보세요.");
		String MW_Name= scan.nextLine();

		System.out.println("몬스터 무기의 종류를 입력해보세요.");
		String MW_category= scan.nextLine();
				
		System.out.println("몬스터 무기의 공격력을 입력해보세요.");
		int MW_damage= scan.nextInt();
		scan.nextLine();
		//입력받은값 대입
		Monster monster=new Monster(M_Name,M_hp,M_damage,MW_Name,MW_category,MW_damage);
		System.out.println("\n--------------------------------------------------------------------------------------------------------------------------");

		int round=1;
		int error=0;
		int monster_attack,player_attack=0;
		
		//게임 로직
		while(true) {
			//잘못된값이 입력되면 error가 1이되고 해당라운드 재시작.
			error=0;
			//라운드마다 현재 남은 체력을 보여준다.
			System.out.printf("\n현재 %s(플레이어)의 HP : %d \t %s(몬스터)의 HP : %d\n",
					player.getName(),player.getHP(),monster.getName(),monster.getHP());
			
			// 선공은 플레이어로 시작하며 턴제 방식이다.
			if(round%2==1) {
				System.out.printf("\n%s(플레이어) 차례입니다.\n 1. 기본공격(데미지: %d)\t2.수면(hp회복 : 10)\t3.파이어볼(데미지 : %d)\n입력:",
						player.getName(),player.getDamage(),player.getSkillDamage());
				player_attack= scan.nextInt();
				scan.nextLine();
				
				switch(player_attack) {
				case 1:
					player.attack(monster);
					break;
					
				case 2:
					player.sleep();
					break;
					
				case 3:
					player.fireball(monster);
					break;
				default:
					System.out.println("\n잘못된 입력값입니다.\n");
					error=1;
					break;
				} // switch문 종료
				
			}
			else {
				System.out.printf("\n%s(몬스터) 차례입니다.\n 1. 기본공격(데미지: %d)\t2.수면(hp회복 : 10)\t3.강타(데미지 : %d)\n입력:",
						monster.getName(),monster.getDamage(),monster.getSkillDamage());
				monster_attack= scan.nextInt();
				scan.nextLine();
				
				switch(monster_attack) {
				case 1:
					monster.attack(player);
					break;
					
				case 2:
					monster.sleep();
					break;
					
				case 3:
					monster.smash(player);
					break;
				default:
					System.out.println("\n잘못된 입력값입니다.\n");
					error=1;
					break;
				} // switch문 종료
			
			}
			
			System.out.println("\n--------------------------------------------------------------------------------------------------------------------------");

			if(monster.getHP()==0) {
								System.out.printf("\n%s(몬스터)가 사망했습니다.\n\n%s(플레이어)의 승리입니다.",monster.getName(),player.getName());
				break;
			}
			
			if(player.getHP()==0) {
				System.out.printf("%s(플레이어)가 사망했습니다.\n%s(몬스터)의 승리입니다.",player.getName(),monster.getName());
				break;
			}
			
			if(error!=1)
				round++;
			
		}
		
	}
}
