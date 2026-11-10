package com.morrisons.common.helper;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public interface SortData {
    public ArrayList doSortOnTwoFields(ArrayList<String> arrActualList, String StringsOrder);
    void doSort(ArrayList<Object> arrActualList, String StringsOrder);
}

class SortDataDate implements SortData {

    public ArrayList doSortOnTwoFields(ArrayList<String> arrActualList, String StringsOrder) {
        ArrayList<String> sortedList = new ArrayList<String>();
        ArrayList<String> sortedList1 = new ArrayList<String>();
        for (String s : arrActualList) {
            sortedList.add(s);
        }
        Collections.sort(sortedList, new Comparator() {

            @Override
            public int compare(Object a, Object b) {
                int k;
                String aStr = a.toString();
                String bStr = b.toString();
                int iSecondField = aStr.lastIndexOf('|');
                int iSecondField1 = bStr.lastIndexOf('|');
                aStr = aStr.substring(0, iSecondField);
                bStr = bStr.substring(0, iSecondField1);
//                int dayNumberSuffix = currentDate.getDayOfMonth();

                Locale locale = new Locale("en");
                DateTimeFormatter dateFormat1 = (DateTimeFormatter.ofPattern("EEE" + " " + "d" + " MMM" + " yyyy", locale));
                LocalDate localDate = LocalDate.parse(aStr.trim(), dateFormat1);
                LocalDate localDate1 = LocalDate.parse(bStr.trim(), dateFormat1);
//                aStr = dateFormat1.format(localDate);
//                bStr = dateFormat1.format(localDate1);
                if (StringsOrder.equalsIgnoreCase("asc")) {
                    k = localDate.compareTo(localDate1);
                    if (k == 0)
                        return aStr.substring(iSecondField).compareTo(bStr.substring(iSecondField1));
                    else
                        return k;
                } else if (StringsOrder.equalsIgnoreCase("desc")) {
                    k = localDate1.compareTo(localDate);
                    if (k == 0)
                        return bStr.substring(iSecondField1).compareTo(aStr.substring(iSecondField));
                    else
                        return k;
                }
                return 0;
            }
        });
        for (int i = 0; i < sortedList.size(); i++) {
            sortedList1.add(sortedList.get(i));
        }
        System.out.println(arrActualList + "| " + sortedList1);
        ExtentCucumberAdapter.addTestStepLog("Expected list  " + sortedList1.toString() + " Actual List  " + arrActualList.toString());
        junit.framework.Assert.assertTrue(sortedList1.equals(arrActualList));
        return sortedList1;
    }
    @Override
    public void doSort(ArrayList<Object> arrActualList, String StringsOrder) {
        ArrayList<String> sortedList = new ArrayList<>();
        ArrayList<String> sortedList1 = new ArrayList<>();
        for (Object s : arrActualList) {
            sortedList.add(s.toString());
        }
        if (StringsOrder.equalsIgnoreCase("asc")) {
            Collections.sort(sortedList, new Comparator() {
                @Override
                public int compare(Object a, Object b) {
                    String aStr = a.toString();
                    String bStr = b.toString();
                    Locale locale = new Locale("en");
                    DateTimeFormatter dateFormat1 = (DateTimeFormatter.ofPattern("EEE" + " " + "d" + " MMM" + " yyyy",locale));
                    LocalDate localDate = LocalDate.parse(aStr.trim(),dateFormat1);
                    LocalDate localDate1 = LocalDate.parse(bStr.trim(),dateFormat1);
                    return localDate.compareTo(localDate1);
                }
            });
            for(int i = 0; i < sortedList.size(); i++) {
                sortedList1.add(sortedList.get(i));
            }
            ExtentCucumberAdapter.addTestStepLog("Expected list  " + sortedList1 + " Actual List  " + arrActualList);
            junit.framework.Assert.assertTrue(sortedList1.equals(arrActualList));
        } else {
            Collections.sort(sortedList, new Comparator() {
                @Override
                public int compare(Object a, Object b) {
                    String aStr = a.toString();
                    String bStr = b.toString();
                    Locale locale = new Locale("en");
                    DateTimeFormatter dateFormat1 = (DateTimeFormatter.ofPattern("EEE" + " " + "d" + " MMM" + " yyyy",locale));
                    LocalDate localDate = LocalDate.parse(aStr.trim(),dateFormat1);
                    LocalDate localDate1 = LocalDate.parse(bStr.trim(),dateFormat1);
                    return localDate1.compareTo(localDate);
                }
            });
            for(int i = 0; i < sortedList.size(); i++) {
                sortedList1.add(sortedList.get(i));
            }
            ExtentCucumberAdapter.addTestStepLog("Expected list  " + sortedList1 + " Actual List  " + arrActualList);
            junit.framework.Assert.assertTrue(sortedList1.equals(arrActualList));
        }
    }
}

    class SortDataString implements SortData {

        public ArrayList doSortOnTwoFields(ArrayList<String> arrActualList, String StringsOrder) {
            ArrayList<String> sortedList = new ArrayList<String>();
            ArrayList<String> sortedList1 = new ArrayList<String>();
            for (String s : arrActualList) {
                sortedList.add(s);
            }
            Collections.sort(sortedList, new Comparator() {

                @Override
                public int compare(Object a, Object b) {
                    int k;
                    String aStr = a.toString();
                    String bStr = b.toString();
                    int iSecondField = aStr.lastIndexOf('|');
                    int iSecondField1 = bStr.lastIndexOf('|');
                    aStr = aStr.substring(0, iSecondField);
                    bStr = bStr.substring(0, iSecondField1);

                    if (StringsOrder.equalsIgnoreCase("asc")) {
                        k = aStr.compareTo(bStr);
                        if (k == 0)
                            return aStr.substring(iSecondField).compareTo(bStr.substring(iSecondField1));
                        else
                            return k;
                    } else if (StringsOrder.equalsIgnoreCase("desc")) {
                        k = bStr.compareTo(aStr);
                        if (k == 0)
                            return bStr.substring(iSecondField1).compareTo(aStr.substring(iSecondField));
                        else
                            return k;
                    }
                    return 0;
                }
            });
            for (int i = 0; i < sortedList.size(); i++) {
                sortedList1.add(sortedList.get(i));
            }
            System.out.println(arrActualList + "| " + sortedList1);
            ExtentCucumberAdapter.addTestStepLog("Expected list  " + sortedList.toString() + " Actual List  " + arrActualList.toString());
            junit.framework.Assert.assertTrue(sortedList1.equals(arrActualList));
            return sortedList1;
        }

        @Override
        public void doSort(ArrayList<Object> arrActualList, String StringsOrder) {
            ArrayList<String> sortedList = new ArrayList<String>();
                for (Object s : arrActualList) {
                    sortedList.add(s.toString());
                }
            if (StringsOrder.equalsIgnoreCase("asc")) {
                if (StringsOrder.equalsIgnoreCase("asc")) {
                    Collections.sort(sortedList);
                }
                ExtentCucumberAdapter.addTestStepLog("Expected list  " + sortedList.toString() + " Actual List  " + arrActualList.toString());
                junit.framework.Assert.assertTrue(sortedList.toString().equals(arrActualList.toString()));
            } else {
                Collections.sort(sortedList, new Comparator() {
                    @Override
                    public int compare(Object a, Object b) {
                        String aStr = a.toString();
                        String bStr = b.toString();
                        return bStr.compareTo(aStr);
                    }
                });
                ExtentCucumberAdapter.addTestStepLog("Expected list  " + sortedList.toString() + " Actual List  " + arrActualList.toString());
                junit.framework.Assert.assertTrue(sortedList.toString().equals(arrActualList.toString()));
            }
        }
    }

    class SortDataInt implements SortData {

        public ArrayList doSortOnTwoFields(ArrayList<String> arrActualList, String StringsOrder) {
            ArrayList<String> sortedList = new ArrayList<String>();
            ArrayList<String> sortedList1 = new ArrayList<String>();
            for (String s : arrActualList) {
                sortedList.add(s);
            }
            Collections.sort(sortedList, new Comparator() {

                @Override
                public int compare(Object a, Object b) {
                    int k;
                    String aStr = a.toString();
                    String bStr = b.toString();
                    int iSecondField = aStr.lastIndexOf('|');
                    int iSecondField1 = bStr.lastIndexOf('|');
                    aStr = aStr.substring(0, iSecondField);
                    bStr = bStr.substring(0, iSecondField1);

                    if (StringsOrder.equalsIgnoreCase("asc")) {
                        k = Integer.valueOf(aStr).compareTo(Integer.valueOf(bStr));
                        if (k == 0)
                            return aStr.substring(iSecondField).compareTo(bStr.substring(iSecondField1));
                        else
                            return k;
                    } else if (StringsOrder.equalsIgnoreCase("desc")) {
                        k = Integer.valueOf(bStr).compareTo(Integer.valueOf(aStr));
                        if (k == 0)
                            return bStr.substring(iSecondField1).compareTo(aStr.substring(iSecondField));
                        else
                            return k;
                    }
                    return 0;
                }
            });
            for (int i = 0; i < sortedList.size(); i++) {
                sortedList1.add(sortedList.get(i));
            }
            System.out.println(arrActualList + "| " + sortedList1);
            ExtentCucumberAdapter.addTestStepLog("Expected list  " + sortedList.toString() + " Actual List  " + arrActualList.toString());
            junit.framework.Assert.assertTrue(sortedList1.equals(arrActualList));
            return sortedList1;
        }

        @Override
        public void doSort(ArrayList<Object> arrActualList, String StringsOrder) {
            ArrayList<Integer> sortedList = new ArrayList<Integer>();
                for (Object s : arrActualList) {
                    sortedList.add(Integer.valueOf(s.toString()));
                }
            if (StringsOrder.equalsIgnoreCase("asc")) {
                if (StringsOrder.equalsIgnoreCase("asc")) {
                    Collections.sort(sortedList);
                }
                ExtentCucumberAdapter.addTestStepLog("Expected list  " + sortedList.toString() + " Actual List  " + arrActualList.toString());
                junit.framework.Assert.assertTrue(sortedList.toString().equals(arrActualList.toString()));
            } else {
                Collections.sort(sortedList, new Comparator() {
                    @Override
                    public int compare(Object a, Object b) {
                        int aStr = Integer.valueOf(a.toString());
                        int bStr = Integer.valueOf(b.toString());
                        return Integer.valueOf(bStr).compareTo(Integer.valueOf(aStr));
                    }
                });
                ExtentCucumberAdapter.addTestStepLog("Expected list  " + sortedList.toString() + " Actual List  " + arrActualList.toString());
                junit.framework.Assert.assertTrue(sortedList.toString().equals(arrActualList.toString()));
            }
        }
    }


