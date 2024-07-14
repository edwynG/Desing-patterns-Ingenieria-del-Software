// Producto
abstract class Vehicle {
    public String model;
    public int capacty;

    public abstract void acelerate();
}

// Creador
abstract class CreadorToyota {
    public abstract Vehicle createvehicle();

    public void production() {
        Vehicle vehicle = this.createvehicle();
        vehicle.acelerate();

    };
}

// creadores concretos
class ConcretVan extends CreadorToyota {
    @Override
    public Vehicle createvehicle() {
        return new Fortuner();
    }
}

class ConcretSport extends CreadorToyota {
    @Override
    public Vehicle createvehicle() {
        return new Celica();
    }
}

class ConcretSedan extends CreadorToyota {
    @Override
    public Vehicle createvehicle() {
        return new Corolla();
    }
}

// Class Producto concretos
class Corolla extends Vehicle {
    public Corolla() {
        this.model = "Corola";
        this.capacty = 20;
    }

    @Override
    public void acelerate() {
        System.out.println(this.model + " en movimiento..");
    }
}

class Fortuner extends Vehicle {
    public Fortuner() {
        this.model = "Fortune";
        this.capacty = 40;
    }

    @Override
    public void acelerate() {
        System.out.println(this.model + " en movimiento..");
    }
}

class Celica extends Vehicle {
    public Celica() {
        this.model = "Celia";
        this.capacty = 15;
    }

    @Override
    public void acelerate() {
        System.out.println(this.model + " en movimiento..");
    }
}

public class toyota {

    public static void main(String[] args) {
        //Corola
        CreadorToyota p = new ConcretSedan();
        p.production();

        //Celia
        p = new ConcretSport();
        p.production();

        //Camioneta
        p = new ConcretVan();
        p.production();

    }
}