"use strict";
class Counter {
  constructor() {
    //garantiza la instancia unica
    if (Counter.instance != undefined) {
      return Counter.instance;
    }
    // Atributo con la instacia unica
    Counter.instance = this;
    this.count = 0;
  }

  increment() {
    this.count++;
  }
  reset() {
    this.count = 0;
  }
  set setting(value) {
    this.count = value;
  }
  decrement() {
    if (this.count > 0) this.count--;
  }
  get counter() {
    return this.count;
  }
}

// controladores del contador
const controllerSystem = new Counter();
const controllerUser = new Counter();

// interfaz
const interfaceCount = document.getElementById("count");
const btnIncremet = document.getElementById("increment");
const btnDecrement = document.getElementById("decrement");
const btnReset = document.getElementById("reset");

// funcion para que el sistema interactue con la interfaz
const manager = (container, controller) => {
  container.innerText = controller.counter;
  localStorage.setItem("count", controller.counter);
};

// gestion del sistema
if (localStorage.getItem("count") != null) {
  interfaceCount.innerText = localStorage.getItem("count");
  controllerSystem.setting = parseInt(localStorage.getItem("count"));
} else {
  interfaceCount.innerText = "0";
}

// Eventos que ejecuta el usuario
btnIncremet.addEventListener("click", () => {
  controllerUser.increment();
  // gestion del sistema
  manager(interfaceCount, controllerSystem);
});

btnDecrement.addEventListener("click", () => {
  controllerUser.decrement();
  // gestion del sistema
  manager(interfaceCount, controllerSystem);
});

btnReset.addEventListener("click", () => {
  controllerUser.reset();
  // gestion del sistema
  manager(interfaceCount, controllerSystem);
});
