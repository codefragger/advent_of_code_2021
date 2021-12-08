package advent.of.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1SonarSweep {

    public static void main(String[] args) {
        List<Integer> sweeps = readInput();
        long noOfIncreases = 0;

        //noOfIncreases = case1(sweeps, noOfIncreases);
        noOfIncreases = case2(sweeps, noOfIncreases);
        System.out.println(noOfIncreases);
    }

    private static long case2(List<Integer> sweeps, long noOfIncreases) {
        List<Long> windowSumList = new ArrayList<>();
        for (int i = 0; i < sweeps.size(); i++) {
            long sum = 0;
            if(i+2 > sweeps.size() -1 || i+1 > sweeps.size() -1 ) {
                break;
            }
            sum = sweeps.get(i) + sweeps.get(i+1) + sweeps.get(i+2);
            windowSumList.add(sum);
        }
        for (int i = 1; i < windowSumList.size(); i++) {
            if(windowSumList.get(i-1) < windowSumList.get(i)) {
                noOfIncreases++;
            }
        }
        return noOfIncreases;
    }

    private static long case1(List<Integer> sweeps, long noOfIncreases) {
        for (int i = 1; i < sweeps.size(); i++) {
            if(sweeps.get(i-1) < sweeps.get(i)) {
                noOfIncreases++;
            }
        }
        return noOfIncreases;
    }

    private static List<Integer> readInput() {
        List<Integer> sweeps = new ArrayList<>(Arrays.asList(new Integer[]{141, 140, 160, 161, 162, 172, 178, 185, 184, 186, 187, 195, 216, 239, 243, 247, 248, 243, 224, 230, 227, 228, 229, 231, 220, 225, 226, 246, 219, 222, 225, 226, 225, 236, 243, 251, 245, 248, 250, 253, 257, 258, 269, 272, 284, 298, 279, 280, 282, 289, 296, 299, 307, 299, 304, 307, 306, 309, 319, 325, 333, 348, 349, 362, 367, 369, 371, 373, 384, 389, 390, 404, 418, 427, 428, 429, 430, 433, 435, 423, 442, 443, 444, 445, 446, 449, 454, 472, 479, 497, 505, 506, 507, 520, 524, 526, 527, 531, 535, 534, 535, 541, 542, 521, 526, 521, 529, 531, 543, 551, 557, 574, 576, 580, 585, 606, 617, 637, 642, 643, 655, 656, 661, 662, 661, 664, 670, 676, 678, 686, 696, 697, 694, 699, 706, 719, 723, 724, 721, 722, 723, 748, 749, 750, 751, 755, 758, 759, 767, 773, 791, 796, 808, 813, 809, 820, 819, 822, 823, 828, 827, 828, 818, 827, 837, 844, 847, 848, 882, 883, 887, 889, 888, 890, 894, 895, 926, 970, 977, 989, 993, 985, 1003, 997, 1006, 1011, 1017, 1018, 1021, 1023, 1027, 1038, 1040, 1044, 1040, 1046, 1062, 1073, 1078, 1094, 1097, 1101, 1115, 1118, 1114, 1117, 1119, 1124, 1126, 1127, 1131, 1114, 1115, 1134, 1137, 1139, 1141, 1143, 1159, 1162, 1164, 1173, 1178, 1179, 1180, 1181, 1185, 1191, 1192, 1193, 1212, 1210, 1213, 1215, 1211, 1216, 1217, 1230, 1222, 1231, 1232, 1234, 1235, 1228, 1234, 1235, 1246, 1257, 1264, 1262, 1271, 1273, 1274, 1279, 1281, 1292, 1300, 1302, 1304, 1314, 1315, 1320, 1331, 1332, 1333, 1334, 1351, 1352, 1353, 1342, 1341, 1351, 1372, 1389, 1390, 1384, 1390, 1406, 1405, 1410, 1411, 1413, 1433, 1440, 1439, 1445, 1447, 1472, 1467, 1489, 1505, 1506, 1518, 1520, 1523, 1538, 1536, 1547, 1550, 1555, 1557, 1563, 1559, 1565, 1564, 1591, 1592, 1604, 1607, 1606, 1620, 1634, 1631, 1633, 1648, 1663, 1643, 1647, 1652, 1655, 1656, 1658, 1659, 1673, 1674, 1681, 1661, 1666, 1657, 1659, 1672, 1673, 1674, 1683, 1676, 1689, 1691, 1692, 1703, 1719, 1720, 1723, 1727, 1741, 1742, 1749, 1751, 1772, 1788, 1794, 1795, 1797, 1798, 1799, 1800, 1804, 1812, 1803, 1805, 1806, 1807, 1818, 1820, 1801, 1799, 1803, 1802, 1803, 1818, 1815, 1818, 1820, 1833, 1841, 1843, 1849, 1846, 1851, 1852, 1863, 1865, 1866, 1868, 1871, 1872, 1873, 1880, 1894, 1895, 1903, 1907, 1909, 1912, 1902, 1906, 1914, 1915, 1886, 1892, 1893, 1895, 1898, 1900, 1901, 1897, 1899, 1906, 1907, 1891, 1902, 1903, 1911, 1913, 1917, 1915, 1928, 1953, 1963, 1965, 1967, 1973, 1964, 1968, 1971, 1972, 1985, 1999, 1998, 2024, 2048, 2053, 2054, 2056, 2058, 2070, 2072, 2073, 2076, 2077, 2080, 2083, 2091, 2094, 2079, 2089, 2090, 2085, 2089, 2087, 2089, 2090, 2114, 2115, 2117, 2120, 2105, 2110, 2111, 2110, 2124, 2134, 2140, 2150, 2152, 2153, 2154, 2163, 2161, 2162, 2164, 2165, 2177, 2178, 2184, 2185, 2186, 2199, 2206, 2213, 2217, 2234, 2239, 2242, 2253, 2264, 2263, 2271, 2278, 2279, 2280, 2284, 2288, 2299, 2314, 2313, 2312, 2310, 2311, 2314, 2310, 2311, 2326, 2328, 2351, 2335, 2374, 2376, 2372, 2376, 2382, 2386, 2392, 2402, 2403, 2405, 2410, 2411, 2413, 2424, 2425, 2435, 2463, 2443, 2472, 2482, 2484, 2485, 2503, 2506, 2507, 2509, 2505, 2530, 2531, 2527, 2530, 2541, 2542, 2563, 2571, 2572, 2568, 2575, 2576, 2577, 2581, 2582, 2590, 2602, 2619, 2621, 2622, 2625, 2641, 2658, 2672, 2674, 2679, 2676, 2681, 2674, 2675, 2676, 2679, 2700, 2703, 2704, 2685, 2690, 2685, 2699, 2716, 2718, 2714, 2727, 2728, 2729, 2730, 2739, 2746, 2712, 2713, 2715, 2719, 2723, 2714, 2716, 2715, 2723, 2719, 2726, 2727, 2742, 2744, 2750, 2763, 2760, 2761, 2764, 2765, 2781, 2785, 2787, 2803, 2804, 2805, 2809, 2815, 2788, 2792, 2810, 2822, 2824, 2834, 2859, 2858, 2859, 2863, 2864, 2860, 2861, 2859, 2869, 2871, 2860, 2867, 2868, 2873, 2874, 2882, 2890, 2882, 2883, 2891, 2892, 2902, 2911, 2923, 2924, 2928, 2947, 2948, 2949, 2952, 2963, 2966, 2967, 2970, 2973, 2978, 2981, 2973, 2988, 3000, 3001, 3002, 3027, 3002, 3003, 3029, 3030, 3035, 3041, 3043, 3041, 3042, 3012, 3017, 3021, 3026, 3046, 3049, 3059, 3058, 3065, 3066, 3069, 3071, 3073, 3075, 3081, 3079, 3091, 3103, 3117, 3127, 3151, 3122, 3123, 3125, 3148, 3149, 3151, 3152, 3158, 3161, 3165, 3167, 3170, 3173, 3169, 3171, 3176, 3177, 3178, 3179, 3184, 3183, 3185, 3188, 3189, 3205, 3206, 3209, 3210, 3211, 3213, 3223, 3226, 3233, 3236, 3235, 3255, 3263, 3287, 3284, 3291, 3290, 3291, 3295, 3296, 3305, 3301, 3302, 3303, 3329, 3330, 3339, 3345, 3358, 3359, 3360, 3364, 3361, 3369, 3381, 3383, 3384, 3386, 3392, 3391, 3390, 3396, 3426, 3427, 3429, 3428, 3451, 3460, 3461, 3463, 3490, 3497, 3496, 3520, 3525, 3527, 3531, 3533, 3532, 3559, 3563, 3564, 3572, 3574, 3575, 3578, 3579, 3580, 3578, 3572, 3575, 3576, 3560, 3559, 3558, 3560, 3558, 3570, 3572, 3573, 3574, 3581, 3596, 3601, 3597, 3603, 3601, 3612, 3611, 3614, 3624, 3625, 3626, 3642, 3671, 3678, 3681, 3690, 3696, 3694, 3686, 3700, 3701, 3703, 3709, 3711, 3705, 3713, 3711, 3723, 3726, 3728, 3736, 3739, 3740, 3747, 3755, 3758, 3770, 3773, 3765, 3773, 3812, 3814, 3817, 3819, 3826, 3830, 3829, 3831, 3832, 3833, 3834, 3840, 3853, 3856, 3857, 3869, 3886, 3888, 3896, 3880, 3900, 3902, 3905, 3925, 3931, 3934, 3935, 3937, 3940, 3954, 3980, 3981, 3982, 3979, 3980, 3985, 3994, 3999, 4000, 4002, 4014, 4024, 4028, 4029, 4034, 4036, 4045, 4046, 4052, 4053, 4066, 4072, 4085, 4084, 4091, 4092, 4110, 4115, 4128, 4130, 4141, 4145, 4146, 4152, 4153, 4165, 4185, 4175, 4179, 4192, 4207, 4202, 4210, 4212, 4223, 4231, 4232, 4231, 4233, 4236, 4249, 4238, 4239, 4244, 4262, 4276, 4290, 4287, 4295, 4293, 4301, 4302, 4314, 4317, 4323, 4340, 4329, 4330, 4343, 4346, 4370, 4371, 4372, 4387, 4408, 4410, 4415, 4414, 4416, 4431, 4432, 4433, 4438, 4439, 4457, 4449, 4448, 4453, 4454, 4444, 4445, 4453, 4456, 4457, 4452, 4475, 4476, 4474, 4475, 4481, 4462, 4464, 4465, 4467, 4466, 4468, 4480, 4494, 4496, 4499, 4515, 4510, 4512, 4519, 4524, 4507, 4509, 4510, 4519, 4520, 4478, 4481, 4489, 4496, 4502, 4478, 4469, 4475, 4498, 4501, 4507, 4519, 4523, 4549, 4561, 4563, 4577, 4583, 4592, 4612, 4613, 4627, 4661, 4707, 4720, 4721, 4720, 4717, 4679, 4690, 4694, 4699, 4701, 4711, 4715, 4716, 4717, 4718, 4721, 4723, 4731, 4726, 4728, 4730, 4731, 4732, 4746, 4749, 4763, 4762, 4759, 4795, 4804, 4802, 4803, 4790, 4808, 4820, 4836, 4839, 4843, 4857, 4870, 4875, 4865, 4874, 4876, 4892, 4893, 4894, 4900, 4903, 4907, 4915, 4917, 4918, 4919, 4925, 4962, 4963, 4965, 4971, 4972, 4962, 4987, 4994, 4995, 4999, 5001, 5006, 5010, 5017, 5020, 5036, 5037, 5039, 5056, 5058, 5062, 5063, 5059, 5060, 5061, 5056, 5061, 5071, 5069, 5079, 5096, 5097, 5073, 5081, 5082, 5083, 5107, 5111, 5110, 5111, 5125, 5143, 5149, 5151, 5186, 5191, 5193, 5194, 5176, 5178, 5179, 5181, 5182, 5206, 5202, 5209, 5217, 5218, 5225, 5221, 5224, 5226, 5227, 5244, 5245, 5244, 5252, 5259, 5265, 5258, 5262, 5267, 5271, 5275, 5276, 5273, 5274, 5279, 5280, 5281, 5304, 5285, 5286, 5293, 5310, 5315, 5319, 5324, 5325, 5336, 5337, 5339, 5340, 5339, 5340, 5341, 5337, 5334, 5344, 5347, 5361, 5367, 5382, 5390, 5391, 5394, 5397, 5393, 5406, 5413, 5414, 5410, 5407, 5408, 5412, 5413, 5422, 5438, 5432, 5433, 5435, 5459, 5464, 5465, 5468, 5485, 5486, 5487, 5488, 5497, 5498, 5499, 5503, 5506, 5519, 5521, 5525, 5508, 5514, 5518, 5529, 5542, 5544, 5545, 5542, 5543, 5551, 5552, 5527, 5529, 5534, 5536, 5554, 5553, 5554, 5543, 5549, 5550, 5544, 5517, 5528, 5542, 5550, 5569, 5574, 5584, 5581, 5582, 5584, 5577, 5576, 5577, 5586, 5592, 5618, 5622, 5635, 5646, 5649, 5650, 5652, 5667, 5669, 5671, 5672, 5689, 5682, 5680, 5681, 5684, 5695, 5697, 5699, 5700, 5713, 5720, 5737, 5768, 5787, 5785, 5771, 5778, 5784, 5792, 5783, 5787, 5791, 5796, 5806, 5812, 5816, 5815, 5816, 5818, 5820, 5821, 5840, 5859, 5861, 5894, 5897, 5919, 5946, 5947, 5952, 5954, 5957, 5953, 5956, 5933, 5921, 5937, 5942, 5944, 5962, 5964, 5965, 5971, 5972, 5971, 5976, 6014, 6012, 6015, 5999, 6000, 6014, 5999, 6010, 6020, 6026, 6029, 6032, 6045, 6044, 6046, 6085, 6077, 6086, 6113, 6114, 6122, 6119, 6123, 6124, 6126, 6145, 6154, 6161, 6162, 6163, 6164, 6167, 6191, 6193, 6187, 6194, 6201, 6188, 6179, 6197, 6216, 6218, 6223, 6222, 6225, 6211, 6214, 6218, 6187, 6184, 6186, 6212, 6220, 6221, 6223, 6246, 6249, 6259, 6264, 6292, 6296, 6300, 6309, 6327, 6329, 6347, 6349, 6362, 6365, 6357, 6383, 6385, 6390, 6393, 6394, 6398, 6392, 6393, 6394, 6397, 6398, 6420, 6424, 6418, 6419, 6430, 6431, 6437, 6444, 6450, 6452, 6462, 6464, 6466, 6489, 6499, 6509, 6517, 6518, 6519, 6520, 6511, 6512, 6515, 6516, 6517, 6519, 6521, 6523, 6525, 6528, 6535, 6544, 6545, 6560, 6559, 6567, 6586, 6594, 6631, 6639, 6647, 6648, 6650, 6654, 6665, 6662, 6696, 6697, 6698, 6699, 6708, 6709, 6725, 6737, 6746, 6747, 6751, 6765, 6766, 6768, 6779, 6780, 6797, 6822, 6830, 6837, 6834, 6842, 6831, 6849, 6862, 6863, 6864, 6871, 6875, 6881, 6886, 6888, 6898, 6906, 6911, 6912, 6926, 6927, 6928, 6929, 6949, 6951, 6950, 6951, 6950, 6949, 6950, 6951, 6944, 6947, 6946, 6948, 6950, 6951, 6952, 6941, 6946, 6953, 6960, 6959, 6957, 6958, 6960, 6975, 6976, 6978, 6970, 6972, 6970, 6973, 6974, 6985, 6986, 6998, 6999, 7022, 7029, 7028, 7033, 7035, 7037, 7047, 7048, 7061, 7068, 7082, 7081, 7069, 7075, 7077, 7085, 7107, 7108, 7106, 7107, 7110, 7117, 7129, 7136, 7145, 7146, 7144, 7147, 7153, 7154, 7173, 7178, 7179, 7190, 7192, 7199, 7204, 7206, 7210, 7211, 7212, 7216, 7241, 7256, 7261, 7266, 7265, 7267, 7268, 7257, 7258, 7264, 7265, 7270, 7272, 7285, 7297, 7292, 7288, 7292, 7293, 7297, 7296, 7294, 7301, 7304, 7310, 7311, 7297, 7300, 7306, 7315, 7327, 7332, 7333, 7354, 7370, 7382, 7393, 7394, 7395, 7410, 7399, 7400, 7408, 7414, 7419, 7423, 7424, 7428, 7396, 7404, 7413, 7414, 7417, 7414, 7415, 7417, 7418, 7419, 7427, 7434, 7456, 7457, 7472, 7481, 7482, 7483, 7484, 7491, 7495, 7507, 7508, 7509, 7508, 7509, 7510, 7511, 7512, 7520, 7526, 7530, 7535, 7536, 7540, 7536, 7535, 7544, 7545, 7547, 7562, 7541, 7544, 7563, 7572, 7581, 7583, 7570, 7572, 7594, 7598, 7601, 7615, 7619, 7620, 7621, 7644, 7668, 7666, 7668, 7663, 7661, 7662, 7661, 7662, 7676, 7710, 7711, 7712, 7724, 7726, 7736, 7738, 7747, 7748, 7751, 7763, 7754, 7757, 7761, 7764, 7763, 7764, 7768, 7773, 7772, 7787, 7795, 7805, 7821, 7822, 7823, 7837, 7839, 7840, 7834, 7852, 7828, 7817, 7819, 7823, 7834, 7839, 7869, 7889, 7904, 7905, 7913, 7910, 7907, 7913, 7908, 7910, 7912, 7914, 7902, 7904, 7909, 7905, 7908, 7916, 7918, 7919, 7920, 7925, 7930, 7955, 7956, 7959, 7960, 7966, 7970, 7955, 7970, 7971, 7972, 7973, 7974, 7972, 7973, 7972, 7981, 7982, 7985, 7989, 7995, 8013, 8014, 8015, 8017, 8021, 8022, 8026, 8034, 8035, 8037, 8038, 8042, 8045, 8046, 8047, 8063, 8069, 8091, 8094, 8095, 8096, 8112, 8120, 8115, 8119, 8114, 8115, 8147, 8164, 8165, 8167, 8171, 8173, 8176, 8174, 8178, 8205, 8199, 8197, 8198, 8200, 8202, 8207, 8223, 8237, 8238, 8240, 8253, 8264, 8268, 8279, 8280, 8293, 8309, 8310, 8311, 8310, 8316, 8313, 8319, 8347, 8353, 8337, 8362, 8366, 8375, 8380, 8412, 8414, 8419, 8422, 8424, 8425, 8430, 8431, 8449, 8452, 8458, 8447, 8457, 8458, 8472, 8473, 8479, 8485, 8486, 8488, 8489, 8490, 8491, 8497, 8492, 8495, 8501, 8504, 8507, 8524, 8523, 8516, 8521, 8525, 8534, 8535, 8538, 8543, 8544, 8563, 8587, 8592, 8614, 8619, 8627, 8628, 8620, 8616, 8624, 8626, 8627, 8616, 8613, 8614, 8615, 8616, 8621, 8627, 8631, 8640, 8632, 8633, 8643, 8644, 8652, 8655, 8658, 8665, 8662, 8672, 8684, 8685, 8691, 8692, 8707, 8709, 8713, 8714, 8719, 8722, 8725, 8730, 8736, 8748, 8751, 8752, 8756, 8761, 8766, 8775, 8788, 8797, 8798, 8810, 8802, 8797, 8800, 8807, 8811, 8812, 8821, 8825, 8826, 8839, 8830, 8828, 8829, 8835, 8837, 8845, 8850, 8848, 8856, 8864, 8875, 8876, 8886, 8885, 8884, 8899, 8880, 8884, 8886, 8887, 8892, 8893, 8900, 8903, 8906, 8907, 8908, 8911, 8910, 8911, 8913, 8919, 8920, 8918, 8919, 8923, 8924, 8925, 8935, 8936, 8938, 8948, 8950, 8958, 8968, 8979, 8983, 8987, 8988, 8990, 8984, 8985, 8992, 9000, 9016, 9035, 9038, 9040, 9044, 9045, 9041, 9054, 9053, 9054, 9055, 9027, 9028, 9031, 9037, 9036, 9035, 9036, 9029, 9045, 9044, 9052, 9053, 9054, 9071, 9072, 9073, 9076, 9083, 9080, 9081, 9084, 9089, 9102, 9105}));
        //List<Integer> sweeps = new ArrayList<>(Arrays.asList(new Integer[]{199, 200, 208, 210, 200, 207, 240, 269, 260, 263}));
        return sweeps;
    }
}
