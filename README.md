# Nice Start 

### Primera aplicación creada en Desarrollo de Interfaces


De momento ya están realizadas las versiones Portrait y Landscape de la pantalla **login** y la pantalla **signup**.

Estas son algunas capturas de la aplicación:


![login activity](img/cap1.png)

![login activity](img/cap2.PNG)
![login activity](img/cap3.PNG)

![login activity](img/cap4.PNG)
![login activity](img/cap5.png)

![login activity](img/Cap6.PNG)
![login activity](img/Cap7.PNG)

El menú contextual y el menú desplegable permiten diferentes opciones. 
Entre ellas disparar un cuadro de diálogo.

![login activity](img/Cap8.PNG)

![login activity](img/Cap9.PNG)

![login activity](img/Cap10.PNG)



Aquí un extracto del código que hace que funcionen los botones:


```
public void openSignup(View v) {

        Intent intent = new Intent(login.this, Signup.class);
        
        startActivity(intent);
        
    }
```

```
public void openMain(View v){
    
        Intent intent = new Intent(login.this, MainActivity.class);
        
        startActivity(intent);
        
    } 
```

#### Últimos cambios

Octubre 2024: Se han añadido animaciones a la pantalla de inicio, así como la pantalla de perfil.

Noviembre 2024: Se ha añadido un Swiper para actualizar la imagen. Un menú contextual y un cuadro de diáogo.


[![Animación de inicio](https://img.youtu.be/lnR-wquu8TE/0.jpg)](https://youtu.be/lnR-wquu8TE)


Pronto más cambios!

>Este repositorio tiene una licencia
>[Creativecommons Org Licenses By Sa 4](http://creativecommons.org/licenses/by-sa/4.0/)
