package game;


public class Monster {

	private String name;
	private int hp;
	private int damage;
	private Weapon monster_weapon;
	
	// 몬스터 초기화
	public Monster() {
		name="";
		hp=0;
		damage=0;
		monster_weapon=new Weapon();
	}
		
	public Monster(String name, int hp, int damage,String wp_name,String wp_ct,int wp_damage) {
		System.out.printf("몬스터의 초기값을 설정합니다.\n 이름은 %s , hp는 %d , 공격력은 %d입니다.\n",
				name,hp,damage);
		this.name=name;
		this.hp=hp;
		this.damage=damage;
		this.monster_weapon=new Weapon(wp_name,wp_ct,wp_damage);
	}
		
		
	//이름 반환 & 재설정
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	//체력 반환 & 재설정
	public int getHP() {
		return this.hp;
	}
		
	public void setHP(int hp) {
		this.hp=hp;
	}
		
	
	//공격력 반환 & 재설정
	public int getDamage() {
		return this.damage+this.monster_weapon.getWeaponDamage();
	}
			
	public void setDamage(int damage) {
		this.damage=damage;
	}
	//무기 재설정
	//무기반환은 다시 무기 클래스 호출
	
	public void setWeapon(String name,String ct,int damage) {
		this.monster_weapon=new Weapon(name,ct,damage);
	}
	
	//공격
	public void attack(Player p1) {
		System.out.printf("몬스터 %s가 플레이어 %s에게 %d의 피해를 입혔습니다.\n",
				this.name,p1.getName(),this.damage+this.monster_weapon.getWeaponDamage());
		p1.Wounded(this.damage+this.monster_weapon.getWeaponDamage());
	}
	
	//수면 ,수면시 hp10 회복
	public void sleep() {
		System.out.printf("몬스터 %s가 수면으로 10의 hp를 회복했습니다.\n",this.name);
		this.hp+=10;
	}
	
	// skill , 기본공격수치의 2배의 데미지
	public void smash(Player p1) {
		System.out.printf("몬스터 %s가 플레이어 %s에게 %d의 피해를 입혔습니다.\n",
				this.name,p1.getName(),(this.damage+this.monster_weapon.getWeaponDamage())*2);
		p1.Wounded((this.damage+this.monster_weapon.getWeaponDamage())*2);
	}
	
	// 데미지 입을시 hp조정
	public void Wounded(int damage) {
		if(this.hp-damage<0) {
			this.hp=0;
		}
		else
		this.hp-=damage;
	}
	
	public int getSkillDamage() {
		return ((this.damage+this.monster_weapon.getWeaponDamage())*2);
	}
}
