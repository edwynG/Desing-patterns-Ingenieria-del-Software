import java.util.ArrayList;

// Componente
abstract class Program {
    public String instruction;

    public abstract void execute();
}

// hoja
class Simple extends Program {
    public Simple(String str) {
        this.instruction = str;
    }

    @Override
    public void execute() {
        System.out.println(this.instruction);
    }
}

// Compuesto
class Compound extends Program {
    public ArrayList<Program> instructions;

    public Compound(Program segment) {
        this.instructions = new ArrayList<>();
        this.instructions.add(segment);
    }

    public void add(Program segment) {
        this.instructions.add(segment);
    }

    public void remove(Program segement) {
        this.instructions.remove(segement);
    }

    @Override
    public void execute() {
        for (Program program : instructions) {
            program.execute();
        }
        System.out.println("complet instructions\n");
    }
}

public class Programa {
    public static void main(String[] args) {
        // instrucciones simples
        Simple write = new Simple("sw x28,0(x27) #Escritura registro a memoria");
        Simple load = new Simple("lw x39,0(x31) #Carga memoria a registro");
        Simple assign =new Simple("addi x27,30 # asignar valor registro");

        //función
        Compound function = new Compound(load);
        function.add(write);
        function.remove(write);
        function.add(assign);
        function.execute();
    
        //subRutina
        Compound subRutine = new Compound(function);
        function = new Compound(write);
        function.add(load);
        function.add(assign);
        subRutine.add(function);
        subRutine.execute();


        //libreria
        Compound librery = new Compound(subRutine);
        librery.add(function);
        librery.add(write);
        librery.add(load);
        librery.add(assign);
        librery.execute();
    }
}
