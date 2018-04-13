# Android-mvp 

### In Activity or Fragment
```
public class MainActivity extends AppCompatActivity implements com.capton.test.mvp.View{
    DynamicPresenter dynamicPresenter;
    EditText urlEt;
    Button getDataBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dynamicPresenter = new DynamicPresenter(this);
 
        urlEt = findViewById(R.id.url);
        getDataBtn = findViewById(R.id.getData);

        getDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { 
                getData();
            }
        });
        
    }
       // other code

     // 开始数据请求
    public void getData() {
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("url",urlEt.getText().toString());
        dynamicPresenter.getData(this,paramsMap,"Dynamic");

    }

     // 数据请求成功的回调函数
    @Override
    public void dataGot(String rawData,String tag) {
        if ("Dynamic".equals(tag))
          resultTv.setText(rawData);
    }

     // 数据请求失败的回调函数
    @Override
    public void dataGoterror(String error,String tag) {
        if ("Dynamic".equals(tag)) {
            System.out.println("MainActivity.dataGoterror ");
            resultTv.setText(error);
        }
    }

}
    
```



