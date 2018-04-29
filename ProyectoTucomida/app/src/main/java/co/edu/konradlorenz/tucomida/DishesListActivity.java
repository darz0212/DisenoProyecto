package co.edu.konradlorenz.tucomida;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DishesListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DishesAdapter adapter;
    private List<Dish> dishList;
    private int columns=2;
    private int dpheight,dpWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishes_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        dishList = new ArrayList<>();
        adapter = new DishesAdapter(this, dishList);

        dpheight = DishesListActivity.this.getResources().getConfiguration().screenHeightDp;
        dpWidth=DishesListActivity.this.getResources().getConfiguration().screenWidthDp;

        if(dpheight < 600 && dpWidth<600){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        if(DishesListActivity.this.getResources().getConfiguration().orientation ==
                DishesListActivity.this.getResources().getConfiguration()
                        .ORIENTATION_LANDSCAPE){
            if(dpWidth >= 600 ){
                columns = 3;
            }
        }

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, columns);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(columns, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        addingDishes();
    }


    public void addingDishes(){
        int[] dishesImages = new int[]{
                R.drawable.dish1,
                R.drawable.dish2,
                R.drawable.dish3,
                R.drawable.dish4,
                R.drawable.dish5,
                R.drawable.dish6};

        String ingredients = "250 gr. de fideos \n" +
                "4 dientes ajos picados 100 grs guisantes \n " +
                "1/2 pimiento rojo 250 grs judias verdes \n" +
                "750 ml. de Caldo para Fideuá Fácil 100% Natural \n" +
                "75 ml. vino blanco \n" +
                "300 grs chocos\n" +
                "300 grs gambas\n" +
                "1 pizca colorante";

        /*
        Dificultades: facil, casero, experto
         */

        String steps ="Paso 1: Verter los fideos en la paellera con un poco de aceite. Remover hasta que se doren y retirar \n" +
                "Paso 2: Sofreír los ajos, el pimiento, los chocos, las judias verdes y los guisantes. \n" +
                "Paso 3: Añadir el Caldo para Fideuá Fácil 100% Natural de Gallina Blanca , el vino y el colorante. Incorporar las gambas y los fideos dorados con antelación \n" +
                "Paso 4: Dejar cocer 10-12 minutos a fuego medio y destapado, 3 minutos antes de apartarlo. Se puede gratinar antes de servir.";

        List<Comment> commentList = new ArrayList<>();
        Comment newComment = new Comment("Me","Alejandro","Me gusto mucho");
        commentList.add(newComment);
        newComment = new Comment("Me","Goku Perez","Facil de preparar");
        commentList.add(newComment);

        Dish newDish = new Dish("Fideua",dishesImages[0],ingredients,20,"Casero",
                steps,R.drawable.video,15000, (ArrayList<Comment>) commentList);
        dishList.add(newDish);

/////////Plato 2

        ingredients = "1 lata pimientos asados de 400 grs  \n" +
                "1 litro de Caldo de Pollo Gallina Blanca \n" +
                "2 dl. nata líquida  \n" +
                "1 cucharadita Avecrem Ajo y Perejil Granulado \n" +
                "1 cucharada azúcar  aceite de oliva \n" +
                "2 cucharadas copos de patata";

        steps ="Paso 1: Confitar en una sartén los pimientos previamente escurridos con el aceite, el azúcar y sazonar con Avecrem Ajo y Perejil Granulado \n" +
                "Paso 2: Calentar el Caldo de Pollo Gallina Blanca junto con el jugo de la lata de los pimientos y diluir los copos de patata. Añadir la nata y los pimientos. Triturar y servir muy frío.";

        commentList = new ArrayList<>();
        newComment = new Comment("Me","Pedro","Demasiado facil");
        commentList.add(newComment);
        newComment = new Comment("Me","Juanito","No me gustan las sopas :(");
        commentList.add(newComment);
        newComment = new Comment("Me","Daniela","A mis hijos les encanto y eso que no les gusta las sopas");
        commentList.add(newComment);

        newDish = new Dish("Crema de Pimientos",dishesImages[1],ingredients,10,"Fácil",
                steps,R.drawable.video,6000, (ArrayList<Comment>) commentList);
        dishList.add(newDish);


/////////Plato 3

        ingredients = "2 huevo \n " +
                "1 sobre 4 quesos rallado \n" +
                "aceite de oliva  \n" +
                "1 tomate maduro \n" +
                "rebanadas de pan";

        steps ="Paso 1: Batimos los huevos, ponemos una pizca de sal y añadimos unas cucharadas de quesos (al gusto), hacemos la tortilla. \n" +
                "Paso 2: Acompañamos de unas rebanadas de pan untadas con tomate y aceite.";

        commentList = new ArrayList<>();
        newComment = new Comment("Me","Alejandra","Vale mas el domicilio...");
        commentList.add(newComment);
        newComment = new Comment("Me","Andrea","Muy facil de hacer");
        commentList.add(newComment);

        newDish = new Dish("Tortilla rápida",dishesImages[2],ingredients,10,"Fácil",
                steps,R.drawable.video,4000, (ArrayList<Comment>) commentList);
        dishList.add(newDish);

/////////Plato 4

        ingredients = "1 kilo judia extrafina congelada  \n" +
                "4 ajo en laminas \n" +
                "100 grs. jamon dulce a taquitos  \n" +
                "Esencias Gallina Blanca de Tomillo y Romero \n" +
                "aceite de oliva";

        steps ="Paso 1: Hervir las judias con poca agua y sal, durante 6 minutos escurrir y reservar. \n" +
                "Paso 2: En una sartén ponemos un poco de aceite y freímos los ajos, añadimos dos cubitos de Esencias Gallina Blanca de Tomillo y Romero y las deshacemos, añadimos el jamón dulce salteamos todo.\n"+
                "Paso 3: Por último pondremos las judias, mezclamos bien, tapamos y dejamos cocer todo junto 5 minutos.";

        commentList = new ArrayList<>();
        newComment = new Comment("Me","Rosa","Muy delicioso.");
        commentList.add(newComment);
        newComment = new Comment("Me","Roberto","Es bueno y barato");
        commentList.add(newComment);

        newDish = new Dish("Judias Salteadas",dishesImages[3],ingredients,10,"Fácil",
                steps,R.drawable.video,6000, (ArrayList<Comment>) commentList);
        dishList.add(newDish);

/////////Plato 5

        ingredients = "1 litro batido de vainilla  \n" +
                "5 cucharadas azucar \n" +
                "1 cucharada postre harina de maíz  \n" +
                "7 bizcochos bizcochos \n" +
                "canela";

        steps ="Paso 1: Estas son unas natillas para una emergencia, que viene alguien a cenar de imprevisto y no tienes nada, pues las haces y quedas como una anfitriona de lujo. Pon el litro de batido de vainilla a calentar, menos una tacita en la que habrás desecho la harina de maíz, le añades el azúcar y la harina de maíz disuelta, y una pizca de canela, cuando hierva apartar y echar en cazuelitas individuales, adornar con bizcochos y espolvorear con canela.";

        commentList = new ArrayList<>();
        newComment = new Comment("Me","Jesus ","Para navidad.");
        commentList.add(newComment);

        newDish = new Dish("Natilla rápida",dishesImages[4],ingredients,5,"Fácil",
                steps,R.drawable.video,3000, (ArrayList<Comment>) commentList);
        dishList.add(newDish);


/////////Plato 6

        ingredients = "1 Vasito de arroz basmati  \n" +
                "200 gr. Judías verdes cocidas en conserva \n" +
                "80 gr. Atún de lata en aceite de oliva  \n" +
                "50 gr. Zanahorias aliñadas, \n" +
                "6 Tomates cherry,  \n" +
                "al gusto Sal, \n" +
                "al gusto Vinagre de jerez,  \n" +
                "aceite del contenido de la lata de atún";

        steps ="Paso 1: ¿Cuantas veces llegamos a casa para comer o cenar y tenemos que improvisar con nuestro fondo de alimentos? Este es uno de esos casos. \n" +
                "Paso 2: Introducimos en el microondas el vasito de arroz basmati durante un minuto\n"+
                "Paso 3: Mientras tanto enjuagamos las judias verde en conserva y dejamos escurrir."+
                "Paso 4: Cuidando de no quemarnos, el arroz lo introducimos en un bol, seguidamente las judias escurridas y removemos, le añadimos la sal, el vinagre de jerez, el contenido de la lata de atún con su aceite y volvemos a remover.\n"+
                "Paso 5: Finalmente adornamos con unos tomatitos cherry a los que habremos salado y las zanahorias aliñadas.";

        commentList = new ArrayList<>();
        newComment = new Comment("Me","Roa","De las señoras");
        commentList.add(newComment);
        newComment = new Comment("Me","Carlos","Delicioso");
        commentList.add(newComment);

        newDish = new Dish("Ensalada de Arroz",dishesImages[5],ingredients,10,"Fácil",
                steps,R.drawable.video,7000, (ArrayList<Comment>) commentList);
        dishList.add(newDish);




        adapter.notifyDataSetChanged();

    }


    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


    //Métodos del main_menu
    @Override public boolean onCreateOptionsMenu(Menu mainMenu){

        getMenuInflater().inflate(R.menu.main_menu,mainMenu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem option_menu){

        int id = option_menu.getItemId();

        if(id == R.id.logout){
            Intent i = new Intent(this,LoginActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(option_menu);
    }
}
