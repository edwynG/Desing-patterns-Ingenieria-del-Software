class Counter:
    def __init__(self) -> None:
        self.count=0
    
    def __new__(cls):
        # pregunta si no esta el atributo _instance
        if not hasattr(cls,"_instance"):
            #crea el atributo asignandole la instancia
            cls._instance = super().__new__(cls)
        return cls._instance

    def nextValue(self) -> None:
        self.count+=1

    def __str__(self):
        return f'{self.count}'

ControllerSystem = Counter()
ControllerUser = Counter()
ControllerDev = Counter()

for i in range(0,10):
    ControllerUser.nextValue()

print(ControllerUser,ControllerSystem,ControllerDev)
