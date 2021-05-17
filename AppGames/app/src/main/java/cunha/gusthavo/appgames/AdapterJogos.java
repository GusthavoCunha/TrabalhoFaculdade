package cunha.gusthavo.appgames;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdapterJogos extends BaseAdapter {

    private List<Jogos> jogosList;
    private Context context;
    private LayoutInflater inflater;

    public AdapterJogos(Context context, List<Jogos> listaJogos){
        this.jogosList = listaJogos;
        this.context = context;
        this.inflater = LayoutInflater.from( context );
    }

    @Override
    public int getCount() {
        return jogosList.size();
    }

    @Override
    public Object getItem(int i) {
        return jogosList.get( i );
    }

    @Override
    public long getItemId(int i) {
        return jogosList.get(i).id;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ItemSuporte item;

        if( convertView == null){
           convertView = inflater.inflate(R.layout.layout_lista, null);

            item = new ItemSuporte();
            item.tvNome = convertView.findViewById(R.id.tvListaNome);
            item.tvAno = convertView.findViewById(R.id.tvListaAno);
            item.layout = convertView.findViewById(R.id.llFundoLista);
            item.tvCriador = convertView.findViewById(R.id.tvListaCriador);
            convertView.setTag( item );

        }else {
            item = (ItemSuporte) convertView.getTag();
        }

        Jogos jogos = jogosList.get(i);
        item.tvNome.setText(  jogos.getNome() );
        item.tvAno.setText(  String.valueOf( jogos.getAno() ) );
        item.tvCriador.setText ( jogos.getCriador());

        if( i % 2 == 0 ){
            item.layout.setBackgroundColor(Color.rgb(105,105,105));
        }else {
            item.layout.setBackgroundColor( Color.WHITE );
        }
        return convertView;
    }

    private class ItemSuporte{
        TextView tvNome, tvAno, tvCriador;
        LinearLayout layout;
    }


}
