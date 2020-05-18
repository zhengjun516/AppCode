package com.appcode.tab;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.appcode.R;
import com.appcode.base.BaseAdapter;
import com.appcode.base.BaseViewHolder;
import com.appcode.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends BaseAdapter<Category, BaseViewHolder> {


	private ArrayList<Integer> randomColors = new ArrayList<>();


	public CategoryAdapter(Context context, List<Category> datas) {
		super(context, datas);
		initRandomColors();
	}

	@NonNull
	@Override
	public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
		BaseViewHolder baseViewHolder = new CategoryViewHolder(viewGroup);
		return baseViewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, int index) {
		viewHolder.bindViewHolder(getItem(index),index);
		if(viewHolder instanceof CategoryViewHolder){
			CategoryViewHolder categoryViewHolder = (CategoryViewHolder)viewHolder;
			GradientDrawable gradientDrawable = (GradientDrawable)mContext.getResources().getDrawable(R.drawable.rounded_rectangle_bg);
			gradientDrawable.setColor(getColor(index));
			categoryViewHolder.mItemView.setBackground(gradientDrawable);
		}
		//viewHolder.itemView.setBackgroundColor(getColor(index));
	}

	private int getColor(int  index) {
		int colorIndex = randomColors.get(index%randomColors.size());
		int color = mContext.getResources().getColor(colorIndex);
		return color;
	}

	private void initRandomColors() {
		randomColors.add(R.color.tag1);
		randomColors.add(R.color.tag2);
		randomColors.add(R.color.tag3);
		randomColors.add(R.color.tag4);
		randomColors.add(R.color.tag5);
		randomColors.add(R.color.tag6);
		randomColors.add(R.color.tag7);
		randomColors.add(R.color.tag8);
		randomColors.add(R.color.tag9);
		randomColors.add(R.color.tag10);
	}

}
