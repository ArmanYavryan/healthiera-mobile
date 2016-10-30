package com.healthiera.mobile.fragment;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.healthiera.mobile.R;
import com.healthiera.mobile.component.base.BaseToggleButton;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Calendar extends Fragment implements View.OnClickListener, Animation.AnimationListener,
        AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {

    Animation fadein1, delay;
    ImageView iv, iv2;
    TextView sometext, sometext2;
    View view;
    String Duration = "", days = "Every day";
    CardView cardView, cardView2;
    BaseToggleButton baseToggleButton;
    private LinearLayout pill_take_time_fade_layout;
    private LinearLayout test2;
    private LinearLayout test, test2_2, schedule_fade_layout, card_fade;
    private Animation fadein, fadein2, rotatein, rotateout, rotate1;
    private Animation fadein_2, fadein2_2, rotatein_2, rotateout_2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calendar, container, false);

        firstCardImplementation();
        secondCardImplementation();
        return view;
    }

    private void firstCardImplementation() {
        cardView = (CardView) view.findViewById(R.id.pill_date_cv);
        cardView.setOnClickListener(this);
        iv = (ImageView) view.findViewById(R.id.pill_take_time);

        rotatein = new RotateAnimation(0, 180, 8, 8);
        rotatein.setDuration(300);
        rotatein.setFillAfter(true);
        rotatein.setAnimationListener(this);
        rotateout = new RotateAnimation(180, 0, 8, 8);
        rotateout.setDuration(300);
        rotateout.setFillAfter(true);
        rotateout.setAnimationListener(this);


        pill_take_time_fade_layout = (LinearLayout) view.findViewById(R.id.pill_take_time_fade_layout);
        test2 = (LinearLayout) view.findViewById(R.id.test2);
        test = (LinearLayout) view.findViewById(R.id.test);
        sometext = (TextView) view.findViewById(R.id.sometext);

        rotate1 = new RotateAnimation(0, 2, 8, 8);
        rotate1.setDuration(1000);
        rotate1.setFillAfter(true);
        rotate1.setAnimationListener(this);

        fadein1 = AnimationUtils.loadAnimation(view.getContext(), R.anim.fadein);
        fadein1.setInterpolator(new LinearInterpolator());
        fadein1.setAnimationListener(this);
        fadein1.setFillAfter(true);
        delay = new TranslateAnimation(0, 0, 0, -1);
        delay.setAnimationListener(this);
        delay.setDuration(500);

        fadein = AnimationUtils.loadAnimation(view.getContext(), R.anim.fadein);
        fadein.setInterpolator(new LinearInterpolator());
        fadein.setAnimationListener(this);
        fadein.setFillAfter(true);
        fadein2 = AnimationUtils.loadAnimation(view.getContext(), R.anim.fadein);
        fadein2.setInterpolator(new LinearInterpolator());
        fadein2.setAnimationListener(this);
        fadein2.setFillAfter(true);

        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.chkState);
        frameLayout.removeAllViews();
        baseToggleButton = new BaseToggleButton(view.getContext());
        frameLayout.addView(baseToggleButton);
        baseToggleButton.switchToggle();

        Spinner spinner = (Spinner) view.findViewById(R.id.time_to_take_the_pill);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                view.getContext(),
                R.layout.spinner_item,
                new String[]{"Once a day", "Twice a day", "3 times a day"}
        );
        spinner.setAdapter(adapter);


        baseToggleButton.thumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseToggleButton.track.callOnClick();
            }
        });

        baseToggleButton.track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cardView2.getVisibility() == View.GONE) {
                    baseToggleButton.switchToggle();
                    expand(cardView2);
                    iv.startAnimation(delay);

                } else if (cardView2.getVisibility() == View.VISIBLE) {
                    card_fade.clearAnimation();
                    card_fade.startAnimation(fadein1);
                }
            }
        });

    }

    private void secondCardImplementation() {
        cardView2 = (CardView) view.findViewById(R.id.schedule_cv);
        cardView2.setOnClickListener(this);
        card_fade = (LinearLayout) view.findViewById(R.id.card_fade);


        iv2 = (ImageView) view.findViewById(R.id.iv_schedule);

        schedule_fade_layout = (LinearLayout) view.findViewById(R.id.schedule_fade_layout);
        test2_2 = (LinearLayout) view.findViewById(R.id.test2_2);
        sometext2 = (TextView) view.findViewById(R.id.sometext_2);

        rotatein_2 = new RotateAnimation(0, 180, 8, 8);
        rotatein_2.setDuration(300);
        rotatein_2.setFillAfter(true);
        rotatein_2.setAnimationListener(this);
        rotateout_2 = new RotateAnimation(180, 0, 8, 8);
        rotateout_2.setDuration(300);
        rotateout_2.setFillAfter(true);
        rotateout_2.setAnimationListener(this);


        fadein_2 = AnimationUtils.loadAnimation(view.getContext(), R.anim.fadein);
        fadein_2.setInterpolator(new LinearInterpolator());
        fadein_2.setAnimationListener(this);
        fadein_2.setFillAfter(true);
        fadein2_2 = AnimationUtils.loadAnimation(view.getContext(), R.anim.fadein);
        fadein2_2.setInterpolator(new LinearInterpolator());
        fadein2_2.setAnimationListener(this);
        fadein2_2.setFillAfter(true);

        final TextView tvDate = (TextView) view.findViewById(R.id.tvDate);
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String month;
                        switch (datePicker.getMonth() + 1) {
                            case 1:
                                month = "Jan";
                                break;
                            case 2:
                                month = "Feb";
                                break;
                            case 3:
                                month = "Mar";
                                break;
                            case 4:
                                month = "Apr";
                                break;
                            case 5:
                                month = "May";
                                break;
                            case 6:
                                month = "Jun";
                                break;
                            case 7:
                                month = "Jul";
                                break;
                            case 8:
                                month = "Aug";
                                break;
                            case 9:
                                month = "Sep";
                                break;
                            case 10:
                                month = "Oct";
                                break;
                            case 11:
                                month = "Nov";
                                break;
                            case 12:
                                month = "Dec";
                                break;
                            default:
                                month = "-";
                        }
                        tvDate.setText(month + " " + datePicker.getDayOfMonth() + ", " + datePicker.getYear() + "");
                    }
                };
                java.util.Calendar calendar = java.util.Calendar.getInstance();

                new DatePickerDialog(getActivity(), listener,
                        calendar.get(
                                java.util.Calendar.YEAR),
                        calendar.get(java.util.Calendar.MONTH),
                        calendar.get(java.util.Calendar.DAY_OF_MONTH)
                ).show();
            }
        });

        final RadioButton button1 = (RadioButton) view.findViewById(R.id.rb1);
        final RadioButton button2 = (RadioButton) view.findViewById(R.id.rb2);
        final RadioButton button3 = (RadioButton) view.findViewById(R.id.rb3);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ArrayList mSelectedItems = new ArrayList();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Pick days")
                        .setNegativeButton("Cancel", null)
                        .setPositiveButton("Set", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String s;
                                if (mSelectedItems.contains(1) && mSelectedItems.contains(2) && mSelectedItems.contains(3) &&
                                        mSelectedItems.contains(4) && mSelectedItems.contains(5) && mSelectedItems.contains(6)
                                        && mSelectedItems.contains(0)) {
                                    button1.setChecked(true);
                                    days = "Every day";
                                } else {
                                    s = (mSelectedItems.contains(0) ? "Sun, " : "")
                                            + (mSelectedItems.contains(1) ? "Mon, " : "") + (mSelectedItems.contains(2) ? "Tue, " : "")
                                            + (mSelectedItems.contains(3) ? "Wed, " : "") + (mSelectedItems.contains(4) ? "Thu, " : "")
                                            + (mSelectedItems.contains(5) ? "Fri, " : "") + (mSelectedItems.contains(6) ? "Sat, " : "")
                                    ;
                                    button2.setText("Specific days of week: " + s);
                                    days = "On " + s;
                                }

                            }
                        }).setMultiChoiceItems(R.array.dayofweek, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            // If the user checked the item, add it to the selected items
                            mSelectedItems.add(which);
                        } else if (mSelectedItems.contains(which)) {
                            // Else, if the item is already in the array, remove it
                            mSelectedItems.remove(Integer.valueOf(which));
                        }
                    }

                });
                builder.create();
                builder.show();

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                days = "Every day";
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setTitle("Set days interval");
                View dayCount = getActivity().getLayoutInflater().inflate(R.layout.frag_cal_day_count, null);
                dialog.setView(dayCount);

                final NumberPicker picker = (NumberPicker) dayCount.findViewById(R.id.numberpicker);
                picker.setMinValue(2);
                picker.setMaxValue(100);
                picker.setWrapSelectorWheel(false);
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        button3.setText("Days interval");
                    }
                });
                dialog.setPositiveButton("Set", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        button3.setText("Days interval: every " + picker.getValue() + " days");
                        days = "Every " + picker.getValue() + " days";
                    }
                });
                dialog.show();
            }
        });


        button1.setOnCheckedChangeListener(this);
        button2.setOnCheckedChangeListener(this);
        button3.setOnCheckedChangeListener(this);

        final RadioButton rbutton1 = (RadioButton) view.findViewById(R.id.b1);
        final RadioButton rbutton2 = (RadioButton) view.findViewById(R.id.b2);
        {
            rbutton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                    dialog.setTitle("Number of days for course of treatment");
                    View dayCount = getActivity().getLayoutInflater().inflate(R.layout.frag_cal_day_count, null);
                    dialog.setView(dayCount);

                    final NumberPicker picker = (NumberPicker) dayCount.findViewById(R.id.numberpicker);
                    picker.setMinValue(2);
                    picker.setMaxValue(365);
                    picker.setWrapSelectorWheel(false);
                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            rbutton2.setText("Number of days");
                            Duration = "";
                        }
                    });
                    dialog.setPositiveButton("Set", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            rbutton2.setText("Number of days: " + picker.getValue());
                            Duration = "To take " + picker.getValue() + " days";
                        }
                    });
                    dialog.show();
                }
            });
            rbutton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        rbutton2.setText("Number of days");
                        Duration = "";
                    }
                }
            });

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pill_date_cv:
                if (test2.getVisibility() == View.GONE) {
                    pill_take_time_fade_layout.startAnimation(fadein2);
                } else
                    pill_take_time_fade_layout.startAnimation(fadein);
                break;

            case R.id.schedule_cv:
                if (test2_2.getVisibility() == View.GONE) {
                    schedule_fade_layout.startAnimation(fadein2_2);
                } else {
                    schedule_fade_layout.startAnimation(fadein_2);
                    sometext2.setText(days + ": " + Duration);
                }
                break;

        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == fadein) {
            iv.startAnimation(rotatein);
            collapse(test2);
        } else if (animation == fadein2) {
            iv.startAnimation(rotateout);
            expand(test2);
        } else if (animation == rotatein) {
            pill_take_time_fade_layout.clearAnimation();
        } else if (animation == rotateout) {
            pill_take_time_fade_layout.clearAnimation();
        } else if (animation == fadein_2) {
            iv2.startAnimation(rotatein_2);
            collapse(test2_2);
        } else if (animation == fadein2_2) {
            iv2.startAnimation(rotateout_2);
            expand(test2_2);
        } else if (animation == rotatein_2) {
            schedule_fade_layout.clearAnimation();
        } else if (animation == rotateout_2) {
            schedule_fade_layout.clearAnimation();
        } else if (animation == fadein1) {
            baseToggleButton.switchToggle();
            collapse(cardView2);
        } else if (animation == delay) {
            card_fade.clearAnimation();
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    public void expand(final View v) {
        v.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            public void setDuration(long durationMillis) {
                super.setDuration(300);
            }

            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.getLayoutParams().height = LinearLayout.LayoutParams.WRAP_CONTENT;
                    v.setVisibility(View.VISIBLE);
                    v.requestLayout();
                } else {
                    v.getLayoutParams().height = (int) (targetHeight * interpolatedTime);
                    v.requestLayout();
                }
            }


            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();
        Animation a = new Animation() {
            @Override
            public void setDuration(long durationMillis) {
                super.setDuration(300);
            }

            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                sometext.setText("08:00(Принять 1)");
                test.removeAllViews();
                test.addView(addHour("08:00", "Принять 1"));
                break;
            case 1:
                sometext.setText("08:00(Принять 1), 23:00(Принять 1)");
                test.removeAllViews();
                test.addView(addHour("08:00", "Принять 1"));
                test.addView(addHour("23:00", "Принять 1"));
                break;
            case 2:
                sometext.setText("08:00(Принять 1), 15:30(Принять 1), 23:00(Принять 1)");
                test.removeAllViews();
                test.addView(addHour("08:00", "Принять 1"));
                test.addView(addHour("15:30", "Принять 1"));
                test.addView(addHour("23:00", "Принять 1"));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private FrameLayout addHour(String txttime, String txtcount) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        final TextView time = new TextView(getContext());
        time.setTextColor(Color.parseColor("#2ec9a0"));
        time.setPadding(0, 10, 0, 10);
        time.setTextSize(20);
        time.setGravity(View.TEXT_ALIGNMENT_CENTER);
        time.setText(txttime);

        TextView count = new TextView(getContext());
        count.setTextColor(Color.parseColor("#2ec9a0"));
        count.setPadding(0, 10, 0, 10);
        count.setTextSize(20);
        count.setGravity(View.TEXT_ALIGNMENT_CENTER);
        count.setText(txtcount);
        FrameLayout.LayoutParams layoutparams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutparams.gravity = Gravity.RIGHT;
        count.setLayoutParams(layoutparams);

        frameLayout.addView(time);
        frameLayout.addView(count);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                View dayCount = getActivity().getLayoutInflater().inflate(R.layout.frag_cal_set_hour_count, null);
                NumberPicker picker = (NumberPicker) dayCount.findViewById(R.id.numberpicker);
                picker.setMinValue(1);
                picker.setMaxValue(20);
                picker.setWrapSelectorWheel(false);

                TimePicker timePicker = (TimePicker) dayCount.findViewById(R.id.timepicker);
                timePicker.setIs24HourView(true);
                builder.setView(dayCount);
                builder.setPositiveButton("Set", null);
                builder.setNegativeButton("Cancel", null);
                builder.setTitle("установите час приема и количество");
                builder.create();
                builder.show();
            }
        });
        return frameLayout;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.rb2 && !isChecked) {
            buttonView.setText("Specific days of week");
        }
        if (buttonView.getId() == R.id.rb3 && !isChecked) {
            buttonView.setText("Days interval");
        }
    }
}
