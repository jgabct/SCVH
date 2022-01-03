package br.edu.ifs.academico.utils;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableView;

public class TableAutoresizeModel {
	public static void as( TableView<?> table ) {
		 // To generalize the columns width proportions in relation to the table width,
        // you do not need to put pixel related values, you can use small float numbers if you wish,
        // because it's the relative proportion of each columns width what matters here:

        final float[] widths = { 0.18f, 0.28f, 0.28f, 0.18f, 0.28f, 0.2f, 0.18f };// define the relational width of each column 

        // whether the first column should be fixed
        final boolean fixFirstColumm = true; 

        // fix the first column width when table width is lower than:
        final float fixOnTableWidth = 460; //pixels 

        // calulates sum of widths
        float sum = 0;
        for (double i : widths) {
            sum += i;
        }

        // calculates the fraction of the first column proportion in relation to the sum of all column proportions
        float firstColumnProportion = widths[0] / sum;

        // calculate the fitting fix width for the first column, you can change it by your needs, but it jumps to this width
        final float firstColumnFixSize = fixOnTableWidth * firstColumnProportion;

        // set the width to the columns
        for (int i = 0; i < widths.length; i++) {
            table.getColumns().get(i).prefWidthProperty().bind(table.widthProperty().multiply((widths[i] / sum)));
            // ---------The exact width-------------^-------------^
    if (fixFirstColumm)
            if (i == 0) {
                table.widthProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> arg0, Number oldTableWidth, Number newTableWidth) {

                        if (newTableWidth.intValue() <= fixOnTableWidth) {

                            // before you can set new value to column width property, need to unbind the autoresize binding
                            table.getColumns().get(0).prefWidthProperty().unbind();
                            table.getColumns().get(0).prefWidthProperty().setValue(firstColumnFixSize);

                        } else if (!table.getColumns().get(0).prefWidthProperty().isBound()) {

                            // than readd the autoresize binding if condition table.width > x
                            table.getColumns().get(0).prefWidthProperty()
                                    .bind(table.widthProperty().multiply(firstColumnProportion));
                        }

                    }
                });
            }
        }
	}
}
