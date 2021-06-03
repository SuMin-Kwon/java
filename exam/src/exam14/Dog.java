package exam14;

class Dog extends Animal {
	private String breed;

	
	Dog(String breed) {
		super(breed); // 이부분이 오류
		this.breed = breed;
	}

	Dog(String name, String breed) {
		super(name);
		this.breed = breed;
	}

	public String getBreed() {
		return breed;
	}
}