import com.capton.test.mvp.Presenter;
import com.capton.test.mvp.View;

/**
 * Created by capton on 2018/4/13.
 */

public class DynamicPresenter  extends Presenter <DynamicModel>{

    public DynamicPresenter(View view) {
        super(view);
    }

    @Override
    public DynamicModel getModel() {
        return new DynamicModel(this);
    }

}
