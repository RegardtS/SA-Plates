package regimeister.saplates;

import java.util.ArrayList;
import java.util.Locale;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    
    String[] registration;
    String[] location;
    
    ArrayList<Numberplate> arraylist = new ArrayList<Numberplate>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	
		populateData();
	
		
 
        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);
 
        for (int i = 0; i < registration.length; i++)
        {
            Numberplate np = new Numberplate(registration[i], location[i]);
            // Binds all strings into an array
            arraylist.add(np);
        }
 
        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);
 
        // Binds the Adapter to the ListView
        list.setAdapter(adapter);
 
        // Locate the EditText in listview_main.xml
        editsearch = (EditText) findViewById(R.id.search);
 
        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {
 
            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
                list.smoothScrollToPosition(0);
            }
 
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                    int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
 
            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                    int arg3) {
                // TODO Auto-generated method stub
            }
        });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.action_search) {
			if(editsearch.isShown()){
				editsearch.setVisibility(View.GONE);
				
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(editsearch.getWindowToken(), 0);
				
			}else{
				editsearch.setVisibility(View.VISIBLE);
				editsearch.requestFocus();
				
				//Bring up the keyboard
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.showSoftInput(editsearch, InputMethodManager.SHOW_IMPLICIT);
				
			}
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void populateData(){
		
		String all[] = new String[]{
				"CA","CapeTown",
				"CAM","Caledon & Kleinmond",
				"CAR","Clanwilliam, Lambert's Bay & Graafwater",
				"CAW","George",
				"CBL","Ladismith",
				"CBM","Laingsburg",
				"CBR","Montagu",
				"CBS","MosselBay & Hartenbos",
				"CBT","Murraysburg",
				"CBY","Piketberg",
				"CCA","PrinceAlbert",
				"CCC","Riversdale & Stilbaai",
				"CCD","Robertson & McGregor",
				"CCK","Swellendam & Barrydale",
				"CCM","Tulbagh",
				"CCO","Uniondale",
				"CCP","Vanrhynsdorp & Klawer",
				"CEA","Moorreesburg",
				"CEG","Heidelberg",
				"CEM","Hermanus, Gansbaai, Onrus River & Stanford",
				"CEO","Grabouw",
				"CER","Bonnievale",
				"CES","Albertinia",
				"CEX","Porterville",
				"CEY","Strand & Gordon'sBay",
				"CF","KuilsRiver & Brackenfell & Kraaifontein",
				"CFA","Wolseley",
				"CFG","Vredenburg , SaldanhaBay , St HelenaBay",
				"CFM","SomersetWest",
				"CFP","Velddrif",
				"CFR","KuilsRiver & Brackenfell",
				"CG","Oudtshoorn",
				"CJ","Paarl & Franschhoek",
				"CK","Malmesbury & Darling",
				"CL","Stellenbosch",
				"CN","Wellington",
				"CO","Calitzdorp",
				"CR","Hopefield & Langebaan",
				"CS","Bredasdorp & Napier",
				"CT","Ceres",
				"CV","Vredendal",
				"CW","Worcester,DeDoorns & Touwsrivier",
				"CX","Knysna,Sedgefield & Plettenberg Bay",
				"CY","Bellville,Durbanville,Parow,Goodwood",
				"CZ","Beaufort West",
				"EC","Eastern Cape Province",
				"FS","Free State Province",
				"GP","Gauteng Province",
				"L","Limpopo Province",
				"MP","Mpumalanga Province",
				"NA","Alfred(Harding)",
				"NAT","Amanzimtoti",
				"NB","Bergville",
				"NBA","Babanango",
				"NBB","KwaZulu Natal Administration Boards vehicles",
				"NC","Camperdown",
				"NC","Northern Cape Province",
				"NCO","Colenso",
				"NCV","Butterworth",
				"NCW","Kokstad",
				"NCX","Matatiele",
				"ND","Durban",
				"NDC","Durban (CityCouncil)",
				"NDE","Dundee",
				"NDH","Dannhauser",
				"NDM","Durban Metro Council",
				"NDW","Ndwedwe",
				"NE","Estcourt",
				"NES","Eshowe",
				"NF","Msinga",
				"NGL","Glencoe",
				"NH","Howick",
				"NHL","Hlabisa",
				"NIM","Impendle",
				"NIN","Ingwavuma",
				"NIP","Polela",
				"NIX","Ixopo",
				"NJ","Verulam",
				"NK","Richmond",
				"NKA","Nkandla",
				"NKK","Kranskop",
				"NKR","KlipRiver",
				"NM","Mapumulo",
				"NMA","Mahlabatini",
				"NMG","Magudu",
				"NMR","MooiRiver, Nottingham Road",
				"NN","Newcastle",
				"NND","Nongoma",
				"NO","Melmoth",
				"NP","Pietermaritzburg",
				"NPA","Natal Provincial Administrationvehicles",
				"NPB","Natal Parks Board vehicles",
				"NPC","Pietermaritzburg (CityCouncil)",
				"NPG","Pongola",
				"NPN","Pinetown, CowiesHill",
				"NPP","Paulpietersburg",
				"NPS","Port Shepstone",
				"NR","Lion's River",
				"NRB","Richards Bay",
				"NS","Ngotshe",
				"NT","Tongaat, Stanger, Ballito",
				"NTU","Nqutu",
				"NU","Queensburgh, NewGermany, Waterfall, Hillcrest, Kloof",
				"NUB","Ubombo",
				"NUD","Underberg",
				"NUF","Empangeni",
				"NUL","Umbumbulu",
				"NUM","Umvoti",
				"NUR","UmhlangaRocks",
				"NUT","Utrecht",
				"NUZ","Umlazi",
				"NV","Vryheid",
				"NW","North West Province",
				"NW","Weenen",
				"NX","Alexandra",
				"NZ","Gingindlovu",
				"OA","Bethlehem",
				"OAB","Reitz",
				"OAF","Kestell",
				"OB","Bloemfontein",
				"OBB","Brandfort",
				"OBD","Dewetsdorp",
				"OBG","Reddersburg",
				"OBT","Botshabele",
				"OBW","Phuthadistjhaba",
				"OC","Bethulie",
				"OCC","Springfontein",
				"OD","Boshoff",
				"ODB","Hertzogville",
				"ODD","Dealesville",
				"OE","Edenburg",
				"OEB","Trompsburg",
				"OF","Fauresmith",
				"OFB","Jagersfontein",
				"OFD","Koffiefontein",
				"OFH","Petrusburg",
				"OG","Ficksburg",
				"OGB","Fouriesburg",
				"OH","Frankfort",
				"OHB","Villiers",
				"OHS","Harrismith",
				"OIC","Warden",
				"OIL","Sasolburg",
				"OJ","Heilbron",
				"OK","Hoopstad",
				"OKB","Bultfontein",
				"OKC","Odendaalsrus",
				"OKD","Wesselsbron",
				"OKE","Welkom",
				"OL","Jacobsdal",
				"OM","Kroonstad",
				"OMB","Bothaville",
				"OMF","Viljoenskroon",
				"OMG","Edenville",
				"ON","Ladybrand",
				"ONB","Hobhouse",
				"OND","Clocolan",
				"OO","Lindley",
				"OOD","Steynsrus",
				"OOE","Petrus Steyn",
				"OP","Philippolis",
				"OR","Senekal",
				"ORD","Marquard",
				"ORE","Paul Roux",
				"ORX","Rouxville",
				"OS","Smithfield",
				"OU","Vrede",
				"OUB","Memel",
				"OV","Parys",
				"OVB","Vredefort",
				"OVE","Koppies",
				"OW","Wepener",
				"OX","Winburg",
				"OXD","Theunissen",
				"OXF","Ventersburg",
				"OXG","Excelsior",
				"OXH","Hennenman",
				"OXV","Virginia",
				"OZ","Zastron",
				"TA","Benoni",
				"TAA","Barberton",
				"TAB","Bethal",
				"TAC","Christiana",
				"TAD","Lichtenburg",
				"TAE","Lydenburg",
				"TAF","Zeerust",
				"TAG","Piet Retief",
				"TAH","Nylstroom",
				"TAI","Wolmaransstad",
				"TAJ","Louis Trichardt",
				"TAK","Wolmaranstaddistrict",
				"TAL","Pietersburg",
				"TAM","Wakkerstroom",
				"TAN","Potgietersrus",
				"TAO","Ottosdal",
				"TAP","Graskop",
				"TAQ","Balfour",
				"TAR","Messina",
				"TAS","Delmas",
				"TAT","Greylingstad",
				"TAU","Fochville",
				"TAV","Hercules",
				"TAW","Bronkhorstspruit",
				"TAX","Rodeon, Swartruggens",
				"TAY","Randfontein",
				"TAZ","Brits",
				"TB","Boksburg",
				"TBA","Dullstroom",
				"TBB","Leeudoringstad",
				"TBC","Tzaneen",
				"TBD","Duiwelskloof",
				"TBE","Delareyville",
				"TBF","Hendrina",
				"TBG","Charl Cilliers",
				"TBH","Nelspruit",
				"TBI","Koster",
				"TBJ","Trichard",
				"TBK","Morgenzon",
				"TBL","Machadodorp",
				"TBM","Breyten",
				"TBS","Sabie",
				"TBZ","Thabazimbi",
				"TC","Carolina",
				"TCA","Groblersdal",
				"TCB","Belfast",
				"TCC","Coligny",
				"TCD","Kempton Park",
				"TCE","Westonaria",
				"TCO","Carletonville",
				"TCX","Makwassie",
				"TDD","Pilgrim's Rest",
				"TDG","Nigel",
				"TDH","Witrivier",
				"TDJ","Leslie",
				"TDK","Alberton",
				"TDL","Edenvale",
				"TE","Ermelo",
				"TEA","Amsterdam",
				"TF","Amersfoort",
				"TG","Germiston",
				"TH","Heidelberg",
				"TI","Rustenburg",
				"TJ","Johannesburg",
				"TK","Krugersdorp",
				"TL","Bloemhof",
				"TM","Middelburg",
				"TN","Ventersdorp",
				"TNS","Naboomspruit",
				"TO","Brakpan",
				"TON","Meyerton",
				"TOY","Orkney",
				"TP","Pretoria",
				"TQ","Standerton",
				"TR","Schweizer-Reneke",
				"TRB","Randburg",
				"TS","Springs",
				"TSN","Sandton",
				"TT","Volksrust",
				"TU","Roodepoort-Maraisburg",
				"TV","Vereeniging",
				"TVB","Vanderbijlpark",
				"TW","Witbank",
				"TWB","Warmbaths",
				"TX","Potchefstroom",
				"TY","Klerksdorp",
				"TZ","Stilfontein",
				"WP","Western Cape Province",
				"ZN","KwaZulu-Natal Province"
		};
		
		registration = new String[all.length/2];
		location = new String[all.length/2];
		
		//TODO FIX THIS MESS
		
		ArrayList<String> registrationArrayList = new ArrayList<String>();
		ArrayList<String> locationArrayList = new ArrayList<String>();
		
		for (int i = 0; i < all.length; i++) {
			if (i%2==0) {
				registrationArrayList.add(all[i]);
			}else{
				locationArrayList.add(all[i]);
			}
		}
		
		for (int i = 0; i < registrationArrayList.size(); i++) {
			registration[i] = registrationArrayList.get(i);
		}
		for (int i = 0; i < locationArrayList.size(); i++) {
			location[i] = locationArrayList.get(i);
		}
		
		
		
		
		
		
		
	}
	

}
