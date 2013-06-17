#include <iostream>

#include "sorting.h"

using namespace std;

namespace stuff {

void Sorting::insertionSort(vector<int> list) {
  printList(list);
  for (int j = 1; j < list.size(); j++) {
    int key = list[j];
    int i = j - 1;
    while (i >= 0 && list[i] > key) {
      list[i+1] = list[i];
      i -= 1;
    }
    list[i+1] = key;
    printList(list);
  }
}

void Sorting::printList(vector<int> list) {
  for (int i = 0; i < list.size(); i++) {
    cout << list[i] << " ";
  }
  cout<<endl;
}

void Sorting::mergeSort(vector<int> list) {
}

} // namespace stuff
