package co.edu.konradlorenz.tucomida;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DishesListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DishesAdapter adapter;
    private List<Dish> dishList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishes_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        dishList = new ArrayList<>();
        adapter = new DishesAdapter(this, dishList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        addingDishes();
    }


    public void addingDishes(){
        int[] dishesImages = new int[]{
                R.drawable.dish1,
                R.drawable.dish2,
                R.drawable.dish1,
                R.drawable.dish1,
                R.drawable.dish1,
                R.drawable.dish1,
                R.drawable.dish1,
                R.drawable.dish1,
                R.drawable.dish1,
                R.drawable.dish1};

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
