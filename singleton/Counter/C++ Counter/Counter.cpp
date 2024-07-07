#include <iostream>
using namespace std;
class Counter
{
private:
    int count;
    // constructor privado para que no se creen nuevas instacias
    // garantiza la instacia unica
     Counter(){
        this->count = 0;
    };
public:
   //metodo y atributo estaticas para que dependan la clase más no de la instacia
    static Counter &getInstance()
    {
        static Counter instance;
        // retorna referencia de la instacia unica
        return instance;
    }

    void nextValue()
    {
        this->count++;
    }
    int getCount()
    {
        return this->count;
    }
};

int main(int argc, char const *argv[])
{
    // Se llama a la función getInstance para obtener el control de la instacia
    Counter &Controller = Counter::getInstance();
    Counter &ControllerUser = Counter::getInstance();
    Counter &ControllerSystem = Counter::getInstance();
    for (int i = 0; i < 10; i++)
    {
        Controller.nextValue();
    }
    cout << Controller.getCount() << " " << ControllerUser.getCount()<< " " << ControllerSystem.getCount() << endl;
 
    return 0;
}
