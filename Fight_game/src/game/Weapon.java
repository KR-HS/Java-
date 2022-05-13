package game;

public class Weapon {

	private String name;
	private String category;
	private int weapon_damage;
	
	// 무기 초기화
	public Weapon() {
		name="";
		category="";
		weapon_damage=0;
	}
	
	public Weapon(String name, String category, int weapon_damage) {
		System.out.printf("무기의 초기값을 설정합니다.\n 무기이름은 %s , 무기종류는 %s , 무기공격력은 %d 입니다.\n\n",
				name,category,weapon_damage);
		this.name=name;
		this.category=category;
		this.weapon_damage=weapon_damage;
	}
	
	
	//이름 반환 & 재설정
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	//종류 반환 & 재설정
	public String getCategory() {
		return this.category;
	}
		
	public void setCategory(String category) {
		this.category=category;
	}
		
	
	//공격력 반환 & 재설정
	public int getWeaponDamage() {
		return this.weapon_damage;
	}
			
	public void setWeaponDamage(int damage) {
		this.weapon_damage=damage;
	}
		
	
}
