# Android-mvp 

这是一个简单的android-mvp框架的封装

### 1、构建具体的Presenter,Model子类，例如：
```
// DynamicModel.java Model子类 ，你需要在getData方法内编写你的网络请求代码
public class DynamicModel extends Model {
 
    public DynamicModel(Presenter presenter) {
        super(presenter);
    }

    @Override
    public void getData(Context context, Map<String, Object> paramMap,  String tag) {
         /* 这里执行网络请求代码:
         成功请求后回调 dataGot(String rawData,String tag);
         请求失败后回调 dataGoterror(String error,String tag);
        */

    }

}

// DynamicPresenter.java Presenter子类，你需要实现getModel()方法（传入一个Model子类对象即可）
public class DynamicPresenter  extends Presenter <DynamicModel>{

    public DynamicPresenter(View view) {
        super(view);
    }

    @Override
    public DynamicModel getModel() {
        return new DynamicModel(this);
    }

}
```

### 2、初始化你的Presenter具体实现类对象，并在需要数据的时候调用
其getData(Context context,Map<String, Object> paramMap,String tag)方法

#### In Activity or Fragment
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
    	// paramsMap参数map，传入必要的url，post方法，headers参数，
    	在Model的子类实现方法getData(...)内获取对应的参数。
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("url",urlEt.getText().toString());

        // "Dynamic" 为每一个请求的标签
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



