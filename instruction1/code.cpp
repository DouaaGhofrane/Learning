#include <iostream>  

void hi() {
    std::cout << "Hello World" << std::endl;
}

bool is() {return false;}

 int main() {
    hi();
    int x;
    x=0;
    for(int i=25; i>x; i--){
        std::cout << i << std::endl;
    }
    hi();
 }