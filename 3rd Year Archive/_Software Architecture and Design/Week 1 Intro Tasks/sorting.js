let values = [10, 7, 3, 9, 1, 7, 4];

function bubbleSort(values) {
    let swapped;
    do {
        swapped = false;
        for (let i=0; i < values.length-1; i++) {
            if (values[i] > values[i+1]) {
                let temp = values[i];
                values[i] = values[i+1];
                values[i+1] = temp;
                swapped = true;
            }
        }
    } while (swapped);
}