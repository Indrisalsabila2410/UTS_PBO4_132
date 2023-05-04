class character{
    String nama;
    int heal;
    String weapon;
    int attackP;
    int mana;
    
    // membuat constructor
    public character(String nama, int heal, String weapon, int attackP, int mana){ 
        this.nama = nama;
        this.heal = heal; 
        this.weapon = weapon;
        this.attackP = attackP;
        this.mana = mana;
        print(nama);
    }
    void attack(){
        this.mana -= 5; 
        System.out.println(this.nama+" menyerang si sotong");
        // system.out.println("sotong terkena demage sebanyak "+this.attackP );

    }
    void demage(int attackP){
        System.out.println("ucup terkena demage sebanyak" + attackP);
        this.heal -= attackP;
    }
    void print(String nama2){
        System.out.println("nama: "+nama);  
        System.out.println("heal: "+ heal);
        System.out.println("weapon: "+weapon);
        System.out.println("attack power: " +attackP);
        System.out.println("mana : " +mana);
    }
    public void print() {
    }
}
public class soal3{
    public static void main(String[] args) {
        character character1 = new character("ucup",100,"pedang excalibur",5,100);
        character1.attack();
        character1.demage(10);
        character1.print();
    }
}