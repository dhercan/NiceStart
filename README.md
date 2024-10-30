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

Se han añadido animaciones a la pantalla de inicio, así como la pantalla de perfil.

<iframe width="560" 
height="315" src="https://youtu.be/lnR-wquu8TE" 
frameborder="0" allow="accelerometer; 
autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
</iframe>


Pronto más cambios!

>Este repositorio tiene una licencia
>[Creativecommons Org Licenses By Sa 4](http://creativecommons.org/licenses/by-sa/4.0/)
