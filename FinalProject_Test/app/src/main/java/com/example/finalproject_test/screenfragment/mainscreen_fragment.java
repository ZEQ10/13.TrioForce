package com.example.finalproject_test.screenfragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.finalproject_test.MainScreen;
import com.example.finalproject_test.R;
import com.example.finalproject_test.activity_catagories_choose;
import com.example.finalproject_test.activity_choose_mode;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mainscreen_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mainscreen_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button btnChonTheLoai;
    ImageButton btnDiemDanh, btnThoat, btnThoat2;
    Dialog DiemDanh_dialog;
    Button btncauhoihangngay;
    TextView tvtatcatheloai,tvthethao ;
    private ViewPager2 vp;
    private View view;
    ScrollView sv;
    LinearLayout hidden;
    public mainscreen_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mainscreen_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static mainscreen_fragment newInstance(String param1, String param2) {
        mainscreen_fragment fragment = new mainscreen_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mainscreen_fragment, container, false);
//        btnChonTheLoai= view.findViewById(R.id.TheThao);

        //==========================================ánh xạ======================================================//

        btnDiemDanh=view.findViewById(R.id.DiemDanh);
        btncauhoihangngay=view.findViewById(R.id.btnChoiHangNgay);
        tvtatcatheloai=view.findViewById(R.id.TatCaTheLoai);
        tvthethao=view.findViewById(R.id.txtTheThao);
        hidden=view.findViewById(R.id.hiddenTheLoai);

        //==========================================các sự kiện======================================================//
        tvthethao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_choose_mode.class);
                startActivity(intent);
            }
        });
        tvtatcatheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hidden.getVisibility()==View.GONE){
                    tvtatcatheloai.setText("Thu gọn ▲");
                    hidden.setVisibility(View.VISIBLE);
                }
                else {
                    tvtatcatheloai.setText("Tất cả ▼");
                    hidden.setVisibility(View.GONE);
                }
            }
        });
        btnDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });
        btncauhoihangngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup2();
            }
        });
        return view;
    }

    //==========================================show popup======================================================//
    private void showPopup() {
        // Tạo Dialog mới
        Dialog dialog = new Dialog(requireActivity(), R.style.CustomDialog);

        // Đặt layout cho Dialog
        dialog.setContentView(R.layout.dailycheckin_popup);
        btnThoat=dialog.findViewById(R.id.Thoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
        layoutParams.gravity = Gravity.TOP;
        layoutParams.y = 10;
        dialog.getWindow().setAttributes(layoutParams);
        dialog.show();
    }
    //===========================================show popup 2=====================================================//
    private void showPopup2() {
        // Create a new Dialog using the context of the hosting activity
        Dialog dialog2 = new Dialog(requireActivity(), R.style.CustomDialog);

        // Set the layout for the Dialog
        dialog2.setContentView(R.layout.activity_dailyquiz_popup);
        btnThoat2 = dialog2.findViewById(R.id.dongcuaso);

        // Set the click listener to dismiss the dialog
        btnThoat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.dismiss();
            }
        });

        // Set the window size and gravity
        dialog2.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        WindowManager.LayoutParams layoutParams = dialog2.getWindow().getAttributes();
        layoutParams.gravity = Gravity.TOP;
        layoutParams.y = 10;
        dialog2.getWindow().setAttributes(layoutParams);

        // Show the dialog
        dialog2.show();
    }

}//end class