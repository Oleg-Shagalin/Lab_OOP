package oop.model;

public class AccountsManager {
    private Account[] accounts;
    private int size;

    public AccountsManager(int size) {
        this.size = size;
        accounts = new Account[size];
    }

    public AccountsManager(Account[] accounts) {
        this.accounts = accounts;
    }

    public boolean add(Account account) {
        for (int i = 0; i < size; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return true;
            }
        }

        return false;
    }

    public boolean add(int index, Account account) {
        if (index < size && accounts[index] == null) {
            accounts[index] = account;
            return true;
        }

        return false;
    }

    public Account get(int index) {
        if (index < size) {
            return accounts[index];
        }

        return null;
    }

    public Account set(int index, Account account) {
        if (index < size) {
            accounts[index] = account;
            return accounts[index];
        }

        return null;
    }

    public Account remove(int index) {
        if (index < size) {
            Account account = accounts[index];
            Account[] temp = new Account[size -1];

            for (int i = 0, j = 0; i < size && i != index; i++) {
                temp[j] = accounts[i];
                j++;
            }

            size -= 1;
            accounts = temp;
            return account;
        }

        return null;
    }

    public int size() {
        return size;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public IndividualsTariff getTariff(long accountNumber) {
        for (Account account : accounts) {
            if (account.getNumber() == accountNumber) {
                return account.getTariff();
            }
        }

        return null;
    }

    public IndividualsTariff setTariff(long accountNumber, IndividualsTariff tariff) {
        for (Account account : accounts) {
            if (account.getNumber() == accountNumber) {
                account.setTariff(tariff);
                return account.getTariff();
            }
        }

        return null;
    }
}
