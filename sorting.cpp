#include <cmath>
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

void Sorting::mergeSort(vector<int> list, int p, int r) {
  cout << "mergeSort " << " p = " << p << " r = " << r << endl;
  printList(list);
  if (p < r) {
    int q = floor((p+r)/2);
    mergeSort(list, p, q);
    mergeSort(list, q+1, r);
    list = merge(list, p, q, r);
  }
  printList(list);
}

vector<int> Sorting::merge(vector<int> list, int p, int q, int r) {
  vector<int> retVal;
  int n1 = q - p;
  int n2 = r - q;
  int i = 0, j = 0;
  cout << "n1 = " << n1 << " n2 = " << n2 << " p = " << p << " q = " << q << " r = " << r << endl;

  vector<int> L, R;
  for (i; i < n1; i++)
    L.push_back(list[p + i]);
  cout << "L: "; printList(L);
  for (j; j < n2; j++)
    R.push_back(list[q + j]);
  cout << "R: "; printList(R);
  i = 0;
  j = 0;

  for (int k = p; k < r; k++) {
    if (i < n1 &&  j < n2 && L[i] <= R[j]) {
      retVal.push_back(L[i]);
      i++;
    } else if (j < n2) {
      retVal.push_back(R[j]);
      j++;
    } else if (i < n1) {
      retVal.push_back(L[i]);
      i++;
    }
  }
  printList(retVal);
  return retVal;
}

} // namespace stuff
