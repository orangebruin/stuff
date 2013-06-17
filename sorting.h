#ifndef __SORTING_H__
#define __SORTING_H__

#include <vector>

namespace stuff {

class Sorting {
  public:
    void insertionSort(std::vector<int> list);
    void mergeSort(std::vector<int> list);
  private:
    void printList(std::vector<int> list);
};

} // namespace stuff
#endif
