package com.sabsrocambole.objectanimation1;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


//Versão um
public class MainActivity extends AppCompatActivity {

    //criamos esse flag para que ele detecte quando a animação já aconteceu, para que se a pessoa apertar o mesmo botão novamente a animação tenha o efeito reverso.
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //API --> OBJECT ANIMATOR
    public void efeitoAPI(View view){
        //View view --> como está vinculado o evento de click à um componente visual, o parâmetro de entrada é o próprio componente visual que recebeu o click.


        ImageView img = (ImageView) findViewById(R.id.img);

        //no API usaremos o OBJECT ANIMATOR
        //não é preciso instanciar o object animator, ele já envia essa instância pra gente
        ObjectAnimator anim = ObjectAnimator.ofFloat(img, "alpha", 1f, 0f);
        // offFloat --> é a propriedade do animator que vamos usar (existem outras) --> essa propriedade trabalha com o valores float
        //ObjectAnimator anim = ObjectAnimator.ofFloat(target, propertyName, values); --> vou valar de cada um na prox linha:
        // - target --> é a view que vai receber o efeito, no caso a imageView que nós chamamos de img. Podemos aplicar isso em outras views que não
        //sejam imgViews também.
        // - propertyName --> tipo de animação: vamos usar a propriedade fade ( que serve para controlar o quanto da imagem aparece, vamos fazer ela desaparecer aos poucos)
        // mas a propriedade fade tem um outro nome no imageView, tem dois métodos que podemos usar: os métodos set e get alpha. Então no espaço nós escrevemos
        //somente "alpha".
        // - values --> nesse espaço vc deve colocar primeiro o valor inicial e em seguida um valor final. O valor inicial escolhido foi 1f, significando
        //que teria 100% de opacidade e o valor final foi 0f significando 0% de opacidade. O f do lado dos números é de "float", e o ofFloat trabalha com
        //valores de zero à um.

        anim.setDuration(2000);
        //determinando a duração de 2seg (é obrigatório definir uma duração)

        if (flag){
            //anim.start(); --> começa a animação
            anim.start();
        }
        else{
            //anim.reverse --> reinicia a animação
            anim.reverse();
        }
        flag = !flag;

    }


    //XML --> ANIMATOR INFLATER
    public void efeitoXML(View view){

        ImageView img = (ImageView) findViewById(R.id.img);

        //no XML vamos usar o ANIMATOR INFLATER
        ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(this,R.animator.animacao);
        // Aqui estou fazendo o XML virar objeto, para que possamos usá-lo

        //agora vamos setar a imagem "img" para poder conectá-la com o objeto
        anim.setTarget(img);


        if (flag){
            anim.start();
        }
        else{
            anim.reverse();
        }
        flag = !flag;

    }

}


//link videoAula: youtube.com/watch?v=5cliwYemwe0



























