import com.iota.iri.conf.TestnetConfig;
import com.iota.iri.model.Hash;
import com.iota.iri.model.HashFactory;
import com.iota.iri.model.IntegerIndex;
import com.iota.iri.model.StateDiff;
import com.iota.iri.model.persistables.*;
import com.iota.iri.storage.Indexable;
import com.iota.iri.storage.Persistable;
import com.iota.iri.storage.rocksDB.RocksDBPersistenceProvider;
import com.iota.iri.utils.Pair;

import java.util.ArrayList;
import java.util.List;

public class DeleteMilestone {

    private static final Hash COO_ADDRESS = HashFactory.ADDRESS.create(TestnetConfig.Defaults.COORDINATOR_ADDRESS);


    public static void main(String[] args) throws Exception {
        String dbPath = args.length == 0 ? "testnetdb" : args[0];
        System.out.println("Running with dbpath " + dbPath);

        setUpDb(dbPath);
        deleteMilestone(1326769, "BGMXKNQCFEMOSUAXSYFCPSNIXFEMSMSKX9S9HDUGIHXOAZXPUBDDN9VONWDGWEVVOMEOFEGEEIWQVO999",
                "XFTQWDDPZHUQASHDTNJAOALZKPMJV9QQGXNBQTAUYME9DMMWXMGLIILHXWYHTV9GPFHGCOVREXLFAJ999",
        "SL9NYRFFRUBEUYPDNYBOKCZQ9LLTSBBGHTIACR9PMPMCPKSBPFGRPZGHKVUCMZHFNBSMFWUOLIPTSDHPW",
                "CNEQNBR99IYWKWLBDYSXADLQBCDPAWSIQCKFDANDMVJHSWYLIKYNSNREDGLPPXON9BFQZBKEHDBB9A999",
                "CNEQNBR99IYWKWLBDYSXADLQBCDPAWSIQCKFDANDMVJHSWYLIKYNSNREDGLPPXON9BFQZBKEHDBB9A999");
        deleteMilestone(1326770, "HQ9HTC9KOLGBSWSZKUYERTGBZBWAOLFLSHUEFKCVWVGPTZMXAVTARDSAYVUOPOPVJRAWYEOHCLGAOT999",
                "LD9ETVOUEBLMDPQYZGODLMGWQUHLIXNUY9FEDRYFSUWDOZXJBOKJYHUPBREKQBPZDLFEMOKWFBMWLY999",
                "MCFJEEKRVWGY9JSUXTOYJMPDGRHSXHOZB9KFYMVIJGBVMNUGTROSBUPMLYHWJR9ZVXDTMPFPCBARKXEXB",
                "BZLSEQWJZEEBYDIPVDWVZU99VXNTUWTJZIDKIKFIC9BJQJJHA99ZXMFCIGDVTOEFXRZEZJWKSXVYCO999",
                "BZLSEQWJZEEBYDIPVDWVZU99VXNTUWTJZIDKIKFIC9BJQJJHA99ZXMFCIGDVTOEFXRZEZJWKSXVYCO999"
                );
        deleteMilestone(1326771, "VG9QCXFXOXZZDJXZNVUWDD9IBWDSFBBDK9CRUYSWLFGUXQOWOSXSTPDMUAKTLPBWTDUHNOBXHMLOQD999",
                "PLJUKKGEFCSALXSEHKP9AGJ9UQDSLE99LCYRXNNFXKXNTYXS9IFUNCQHQYIL9PWCRMOMKVHZWA9YB9999",
                "GNTTFRSUKD9N9ZKYDEZGJEOEXRFRBXKRTSBJV9ZMZKGCJJFWQQWOEZUTRXRMRNRMJXEUMXARSZBLDJPRB",
                "BGMXKNQCFEMOSUAXSYFCPSNIXFEMSMSKX9S9HDUGIHXOAZXPUBDDN9VONWDGWEVVOMEOFEGEEIWQVO999",
                "BGMXKNQCFEMOSUAXSYFCPSNIXFEMSMSKX9S9HDUGIHXOAZXPUBDDN9VONWDGWEVVOMEOFEGEEIWQVO999");
        deleteMilestone(1326772, "UPOCBVOCOWHNEDWJSBXCVJBFYVSYHQMXYLXYRROOBW9XEPNAH9HPPIVAGZMCRLAONIS9ZDIVOCMYHD99",
           "KSTGGVZCKICUKXRGXPIPQCFWJYYVUCOHTVHEXCCOWMJLZOBXHGOFBCURIIQQIRUMZTLXZHMRKRCPUY999",
                "CEK99VSFNPCJUMIBGVCYTKHQQVPT9BAMFHM9KNCRLIYGQQDHUDKCMEWKRGM9WZVQRDWMWMYQHOQUXWHN9",
                "HQ9HTC9KOLGBSWSZKUYERTGBZBWAOLFLSHUEFKCVWVGPTZMXAVTARDSAYVUOPOPVJRAWYEOHCLGAOT999",
                "HQ9HTC9KOLGBSWSZKUYERTGBZBWAOLFLSHUEFKCVWVGPTZMXAVTARDSAYVUOPOPVJRAWYEOHCLGAOT999"
                );
        deleteMilestone(1326773,
                "EOKUWTJNMIZYFYDGMMQGJGGNENKICF9ILJQKOPBWPMOWDRTPYETMZGMSCZXSKXNWQQMDZQHMLODZXS999",
                "QFNLUBOACBDCVWCPZYVZLXXIEAVLIQDLWYTZDRWRJBHRWWYVFCPJZKVXK9VGRD9ZT9RZGB9HURVGXL999",
                "ZMCKKE9TCRXAHDXMENSWWCYXVSEVWZFFCGRNPUGUWYZSLMHALXHYBUFWAWAHV9LVIKIVFQJY9DIRBHBPD",
              "VG9QCXFXOXZZDJXZNVUWDD9IBWDSFBBDK9CRUYSWLFGUXQOWOSXSTPDMUAKTLPBWTDUHNOBXHMLOQD999",
        "VG9QCXFXOXZZDJXZNVUWDD9IBWDSFBBDK9CRUYSWLFGUXQOWOSXSTPDMUAKTLPBWTDUHNOBXHMLOQD999");
        deleteMilestone(1326774,
                "FQMMKGUYZRPEKYQDZKNYWSSJZWFWY9GOQWASYFWATVDQCPFCJHVR9ANZURDOJTWQYLAUWC9NWCEYHV999",
                "SPFGTFENBDHPWQAZNHVDSENIATICVZDBUMD9OHAUADOFAZORDOBIZQOBLSEVKJGPZFZQHGSTYPTKRD999",
                "NURUHMFHXIPUGPIAPOMOMGH9TSWMENTTTOA9IEAFFWOSUKGELZRTUFYSNKHDZPURODMRRIOJVNAMGRKFX",
           "UPOCBVOCOWHNEDWJSBXCVJBFYVSYHQMXYLXYRROOBW9XEPNAH9HPPIVAGZMCRLAONIS9ZDIVOCMYHD999",
                "UPOCBVOCOWHNEDWJSBXCVJBFYVSYHQMXYLXYRROOBW9XEPNAH9HPPIVAGZMCRLAONIS9ZDIVOCMYHD999");

        tearDown();
    }

    private static RocksDBPersistenceProvider rocksDBPersistenceProvider;
    private static String dbLogPath = "milestonedeletelog";

    public static void setUpDb(String dbPath) {
        rocksDBPersistenceProvider = new RocksDBPersistenceProvider(dbPath, dbLogPath, 10000);
        rocksDBPersistenceProvider.init();
    }

    public static void tearDown() {
        rocksDBPersistenceProvider.shutdown();
    }

    public static void deleteMilestone(int milestoneIndex, String tail, String head, String bundle, String approvee1, String approvee2) throws Exception {
        Indexable hash1 = HashFactory.TRANSACTION.create(tail);
        Indexable hash2 = HashFactory.TRANSACTION.create(head);
        Hash milestoneBundle = HashFactory.BUNDLE.create(bundle);

        System.out.println("cleaning aggregates");
        cleanAggregates(hash1, hash2, approvee1, approvee2);

        List<Pair<Indexable, ? extends Class<? extends Persistable>>> persistPairs = new ArrayList<>();

        persistPairs.add(new Pair<>(hash1, Transaction.class));
        persistPairs.add(new Pair<>(hash2, Transaction.class));

        persistPairs.add(new Pair<>(new IntegerIndex(milestoneIndex), Milestone.class));

        persistPairs.add(new Pair<>(hash1, StateDiff.class));

        persistPairs.add(new Pair<>(milestoneBundle, Bundle.class));

        persistPairs.add(new Pair<>(hash1, Approvee.class));
        persistPairs.add(new Pair<>(hash2, Approvee.class));

        persistPairs.add(new Pair<>(hash1, ObsoleteTag.class));
        persistPairs.add(new Pair<>(hash2, ObsoleteTag.class));

        persistPairs.add(new Pair<>(hash1, Tag.class));
        persistPairs.add(new Pair<>(hash2, Tag.class));

        System.out.println("Starting to delete milestone #" + milestoneIndex);
        rocksDBPersistenceProvider.deleteBatch(persistPairs);
        System.out.println("Done");
    }

    private static void cleanAggregates(Indexable hash1, Indexable hash2, String approvee1, String approvee2) throws Exception {
        Address txsForAddress = (Address) rocksDBPersistenceProvider.get(Address.class,
                COO_ADDRESS);
        txsForAddress.set.remove(hash1);
        rocksDBPersistenceProvider.save(txsForAddress, COO_ADDRESS);

        Hash branchHash1 = HashFactory.TRANSACTION.create(approvee1);
        Hash branchHash2 = HashFactory.TRANSACTION.create(approvee2);

        Approvee approvers = (Approvee) rocksDBPersistenceProvider.get(Approvee.class, branchHash1);
        approvers.set.remove(hash1);
        approvers.set.remove(hash2);
        rocksDBPersistenceProvider.save(approvers, branchHash1);

        approvers = (Approvee) rocksDBPersistenceProvider.get(Approvee.class, branchHash2);
        approvers.set.remove(hash2);
        rocksDBPersistenceProvider.save(approvers, branchHash2);
    }

}
