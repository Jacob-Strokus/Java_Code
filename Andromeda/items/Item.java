package items;

public abstract class Item {

	private String name;
	private String typeOfAttack;
	private String itemType;

	public Item(String name, String attack, String itemType) {
		this.name = name;
		this.typeOfAttack = attack;
		this.itemType = itemType;
	}

	public String getName() {
		return name;
	}

	public String getTypeOfAttack() {
		return typeOfAttack;
	}

	public String getitemType() {
		return itemType;
	}
}
