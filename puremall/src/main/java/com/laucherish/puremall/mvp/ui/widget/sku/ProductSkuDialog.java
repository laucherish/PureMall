package com.laucherish.puremall.mvp.ui.widget.sku;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.laucherish.puremall.R;
import com.laucherish.puremall.mvp.ui.widget.sku.bean.Product;
import com.laucherish.puremall.mvp.ui.widget.sku.bean.Sku;
import com.laucherish.puremall.mvp.ui.widget.sku.bean.SkuAttribute;
import com.laucherish.puremall.mvp.ui.widget.sku.utils.AppUtils;
import com.laucherish.puremall.mvp.ui.widget.sku.utils.NumberUtils;
import com.laucherish.puremall.mvp.ui.widget.sku.view.OnSkuListener;
import com.laucherish.puremall.mvp.ui.widget.sku.view.SkuSelectScrollView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liufei on 2017/11/30.
 */
public class ProductSkuDialog extends AppCompatDialog {
    @BindView(R.id.ib_sku_close)
    ImageButton ibSkuClose;
    @BindView(R.id.tv_sku_info)
    TextView tvSkuInfo;
    @BindView(R.id.tv_sku_selling_price)
    TextView tvSkuSellingPrice;
    @BindView(R.id.tv_sku_selling_price_unit)
    TextView tvSkuSellingPriceUnit;
    @BindView(R.id.ll_sku_price)
    LinearLayout llSkuPrice;
    @BindView(R.id.scroll_sku_list)
    SkuSelectScrollView scrollSkuList;
    @BindView(R.id.tv_sku_quantity_label)
    TextView tvSkuQuantityLabel;
    @BindView(R.id.tv_sku_quantity)
    TextView tvSkuQuantity;
    @BindView(R.id.btn_sku_quantity_minus)
    TextView btnSkuQuantityMinus;
    @BindView(R.id.et_sku_quantity_input)
    EditText etSkuQuantityInput;
    @BindView(R.id.btn_sku_quantity_plus)
    TextView btnSkuQuantityPlus;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.iv_sku_logo)
    ImageView ivSkuLogo;

    private Context context;
    private Product product;
    private List<Sku> skuList;
    private Callback callback;

    private Sku selectedSku;
    private String priceFormat;
    private String stockQuantityFormat;

    public ProductSkuDialog(@NonNull Context context) {
        this(context, R.style.CommonBottomDialogStyle);
    }

    public ProductSkuDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        this.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_product_sku, null);
        ButterKnife.bind(this, view);
        setContentView(view);
        initView();
    }

    private void initView() {
        ibSkuClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btnSkuQuantityMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantity = etSkuQuantityInput.getText().toString();
                if (TextUtils.isEmpty(quantity)) {
                    return;
                }
                int quantityInt = Integer.parseInt(quantity);
                if (quantityInt > 1) {
                    String newQuantity = String.valueOf(quantityInt - 1);
                    etSkuQuantityInput.setText(newQuantity);
                    etSkuQuantityInput.setSelection(newQuantity.length());
                    updateQuantityOperator(quantityInt - 1);
                }
            }
        });
        btnSkuQuantityPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantity = etSkuQuantityInput.getText().toString();
                if (TextUtils.isEmpty(quantity) || selectedSku == null) {
                    return;
                }
                int quantityInt = Integer.parseInt(quantity);
                if (quantityInt < selectedSku.getStockQuantity()) {
                    String newQuantity = String.valueOf(quantityInt + 1);
                    etSkuQuantityInput.setText(newQuantity);
                    etSkuQuantityInput.setSelection(newQuantity.length());
                    updateQuantityOperator(quantityInt + 1);
                }
            }
        });
        etSkuQuantityInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId != EditorInfo.IME_ACTION_DONE || selectedSku == null) {
                    return false;
                }
                String quantity = etSkuQuantityInput.getText().toString();
                if (TextUtils.isEmpty(quantity)) {
                    return false;
                }
                int quantityInt = Integer.parseInt(quantity);
                if (quantityInt <= 1) {
                    etSkuQuantityInput.setText("1");
                    etSkuQuantityInput.setSelection(1);
                    updateQuantityOperator(1);
                } else if (quantityInt >= selectedSku.getStockQuantity()) {
                    String newQuantity = String.valueOf(selectedSku.getStockQuantity());
                    etSkuQuantityInput.setText(newQuantity);
                    etSkuQuantityInput.setSelection(newQuantity.length());
                    updateQuantityOperator(selectedSku.getStockQuantity());
                } else {
                    etSkuQuantityInput.setSelection(quantity.length());
                    updateQuantityOperator(quantityInt);
                }
                return false;
            }
        });
        scrollSkuList.setListener(new OnSkuListener() {
            @Override
            public void onUnselected(SkuAttribute unselectedAttribute) {
                selectedSku = null;
                Glide.with(context).load(product.getMainImage()).into(ivSkuLogo);
                tvSkuQuantity.setText(String.format(stockQuantityFormat,
                        product.getStockQuantity()));
                String firstUnselectedAttributeName =
                        scrollSkuList.getFirstUnelectedAttributeName();
                tvSkuInfo.setText("请选择：" + firstUnselectedAttributeName);
                btnSubmit.setEnabled(false);
                String quantity = etSkuQuantityInput.getText().toString();
                if (!TextUtils.isEmpty(quantity)) {
                    updateQuantityOperator(Integer.valueOf(quantity));
                } else {
                    updateQuantityOperator(0);
                }
            }

            @Override
            public void onSelect(SkuAttribute selectAttribute) {
                String firstUnselectedAttributeName =
                        scrollSkuList.getFirstUnelectedAttributeName();
                tvSkuInfo.setText("请选择：" + firstUnselectedAttributeName);
            }

            @Override
            public void onSkuSelected(Sku sku) {
                selectedSku = sku;
                Glide.with(context).load(sku.getMainImage()).into(ivSkuLogo);
                tvSkuSellingPrice.setText(String.format(priceFormat,
                        NumberUtils.formatNumber(selectedSku.getSellingPrice())));
                List<SkuAttribute> attributeList = selectedSku.getAttributes();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < attributeList.size(); i++) {
                    if (i != 0) {
                        builder.append("　");
                    }
                    SkuAttribute attribute = attributeList.get(i);
                    builder.append("\"" + attribute.getValue() + "\"");
                }
                tvSkuInfo.setText("已选：" + builder.toString());
                tvSkuQuantity.setText(String.format(stockQuantityFormat,
                        selectedSku.getStockQuantity()));
                btnSubmit.setEnabled(true);
                String quantity = etSkuQuantityInput.getText().toString();
                if (!TextUtils.isEmpty(quantity)) {
                    updateQuantityOperator(Integer.valueOf(quantity));
                } else {
                    updateQuantityOperator(0);
                }
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantity = etSkuQuantityInput.getText().toString();
                if (TextUtils.isEmpty(quantity)) {
                    return;
                }
                int quantityInt = Integer.parseInt(quantity);
                if (quantityInt > 0 && quantityInt <= selectedSku.getStockQuantity()) {
                    callback.onAdded(selectedSku, quantityInt, ivSkuLogo);
                    dismiss();
                } else {
                    Toast.makeText(getContext(), "商品数量超出库存，请修改数量", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void setData(final Product product, Callback callback) {
        this.product = product;
        this.skuList = product.getSkus();
        this.callback = callback;

        priceFormat = context.getString(R.string.comm_price_format);
        stockQuantityFormat = context.getString(R.string.product_detail_sku_stock);

        updateSkuData();
        updateQuantityOperator(1);
    }

    private void updateSkuData() {
        scrollSkuList.setSkuList(product.getSkus());

        Sku firstSku = product.getSkus().get(0);
        if (firstSku.getStockQuantity() > 0) {
            selectedSku = firstSku;
            // 选中第一个sku
            scrollSkuList.setSelectedSku(selectedSku);

            Glide.with(context).load(product.getMainImage()).into(ivSkuLogo);
            tvSkuSellingPrice.setText(String.format(priceFormat,
                    NumberUtils.formatNumber(selectedSku.getSellingPrice())));
            tvSkuSellingPriceUnit.setText("/" + product.getMeasurementUnit());
            tvSkuQuantity.setText(String.format(stockQuantityFormat,
                    selectedSku.getStockQuantity()));
            btnSubmit.setEnabled(selectedSku.getStockQuantity() > 0);
            List<SkuAttribute> attributeList = selectedSku.getAttributes();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < attributeList.size(); i++) {
                if (i != 0) {
                    builder.append("　");
                }
                SkuAttribute attribute = attributeList.get(i);
                builder.append("\"" + attribute.getValue() + "\"");
            }
            tvSkuInfo.setText("已选：" + builder.toString());
        } else {
            Glide.with(context).load(product.getMainImage()).into(ivSkuLogo);
            tvSkuSellingPrice.setText(String.format(priceFormat,
                    NumberUtils.formatNumber(product.getSellingPrice() / 100)));
            tvSkuSellingPriceUnit.setText("/" + product.getMeasurementUnit());
            tvSkuQuantity.setText(String.format(stockQuantityFormat,
                    product.getStockQuantity()));
            btnSubmit.setEnabled(false);
            tvSkuInfo.setText("请选择：" + skuList.get(0).getAttributes().get(0).getKey());
        }
    }

    private void updateQuantityOperator(int newQuantity) {
        if (selectedSku == null) {
            btnSkuQuantityMinus.setEnabled(false);
            btnSkuQuantityPlus.setEnabled(false);
            etSkuQuantityInput.setEnabled(false);
        } else {
            if (newQuantity <= 1) {
                btnSkuQuantityMinus.setEnabled(false);
                btnSkuQuantityPlus.setEnabled(true);
            } else if (newQuantity >= selectedSku.getStockQuantity()) {
                btnSkuQuantityMinus.setEnabled(true);
                btnSkuQuantityPlus.setEnabled(false);
            } else {
                btnSkuQuantityMinus.setEnabled(true);
                btnSkuQuantityPlus.setEnabled(true);
            }
            etSkuQuantityInput.setEnabled(true);
        }

    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        // 解决键盘遮挡输入框问题
        Window window = getWindow();
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        window.setGravity(Gravity.BOTTOM);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        window.getDecorView().setPadding(0, 0, 0, 0);
        // KeyboardConflictCompat.assistWindow(getWindow());
        AppUtils.transparencyBar(getWindow());
    }


    public interface Callback {
        void onAdded(Sku sku, int quantity, ImageView ivAddCartAnim);
    }
}
