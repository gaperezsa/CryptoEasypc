SET SQL_SAFE_UPDATES = 0;

delete from build;

delete from mouse;
insert into mouse (model, price_sl, price_tauret, price_cyp, link_sl, link_tauret, link_cyp, link_picture)
	values ("MOUSE LOGITECH G502 LIGTHSPEED WIFI GAMING",462000,null,468000,"https://speedlogic.com.co/producto/mouse-logitech-g502-ligthspeed-wifi-gaming/"
	,null,"https://clonesyperifericos.com/comprar/mouse-gamer-logitech-g502-hero-rgb/","https://speedlogic.com.co/wp-content/uploads/2020/08/19075.png");

# Case
delete from easypc.case;
insert into easypc.case
	values (1,"CAJA ATX REDRAGON GC-530 RATCHET GAMING",207000,null,null,
		"https://speedlogic.com.co/producto/caja-atx-redragon-gc-530-ratchet-gaming/",
		null,
		null,
		"https://speedlogic.com.co/wp-content/uploads/2020/10/16225.png");  

insert into easypc.case
	values (2,"CAJA ATX XPG BATTLECRUISER",543000,null,null,
		"https://speedlogic.com.co/producto/caja-atx-xpg-battlecruiser/",
		null,
		null,
		"https://speedlogic.com.co/wp-content/uploads/2020/09/16203.png");

insert into easypc.case
	values (3,"CAJA ATX CORSAIR ICUE 465X RGB BLANCO 3 FAN RGB",763000,null,null,
		"https://speedlogic.com.co/producto/caja-atx-corsair-icue-465x-rgb-blanco-3-fan-rgb/",
		null,
		null,
		"https://speedlogic.com.co/wp-content/uploads/2020/09/16186.5.png");
 
insert into easypc.case
	values (4,"CAJA ATX CORSAIR CRYSTAL 570X VIDRIO TEMPLADO RGB",1023000,null,null,
		"https://speedlogic.com.co/producto/caja-atx-corsair-crystal-570x-vidrio-templado-rgb/",
		null,
		null,
		"https://speedlogic.com.co/wp-content/uploads/2020/09/16115.png");

# Cooling
delete from cooling;
insert into cooling
	values (1,"DISIPADOR COOLER MASTER HYPER H410R RGB", 2.28 ,160000,null,175000,
		"https://speedlogic.com.co/producto/disipador-cooler-master-hyper-h410r-rgb/",
		null,
		"https://clonesyperifericos.com/comprar/disipador-cooler-master-hyper-h410r-rgb/",
		"https://speedlogic.com.co/wp-content/uploads/2020/08/10041.png");
        
insert into cooling
	values (2,"REFRIGERACIÓN LÍQUIDA THERMALTAKE WATER 3,0 120 ARGB", 2.66 ,360000,null,null,
		"https://speedlogic.com.co/producto/refrigeracion-liquida-thermaltake-water-30-120-argb/",
		null,
		null,
		"https://speedlogic.com.co/wp-content/uploads/2020/09/11030.png");
        
insert into cooling
	values (3,"REFRIGERACIÓN LÍQUIDA COOLER MASTER ML240P MIRAGE ARGB (TR4)", 3.60 ,769000,null,null,
		"https://speedlogic.com.co/producto/refrigeracion-liquida-cooler-master-ml240p-mirage-argb-tr4/",
		null,
		null,
		"https://speedlogic.com.co/wp-content/uploads/2020/10/11038.png");
        
insert into cooling 
	values (4,"REFRIGERACIÓN LÍQUIDA CORSAIR H100i PLATINUM SE 240 ARGB", 3.60, 947000,null,null,
		"https://speedlogic.com.co/producto/refrigeracion-liquida-corsair-h100i-platinum-se-240-argb/",
		null,
		null,
		"https://speedlogic.com.co/wp-content/uploads/2020/09/11054.png");
        
# GPU
delete from gpu;
insert into gpu 
	values (1,"TARJETA GRÁFICA 2 GIGAS ASROCK RADEON RX-550 PHANTOM", 50, 2, 474000,null,null,
		"https://speedlogic.com.co/producto/tarjeta-grafica-2-gigas-asrock-radeon-rx-550-phantom/",
		null,
		null,
		"https://speedlogic.com.co/wp-content/uploads/2020/09/4054.png",
        "https://gpu.userbenchmark.com/AMD-RX-550/Rating/3925");
        
insert into gpu 
	values (2,"TARJETA GRAFICA 8 GIGAS ASROCK AMD RADEON RX 5500XT PHANTOM GAMING OC", 130, 8, 1175000,null,null,
		"https://speedlogic.com.co/producto/tarejta-grafica-8-gigas-asrock-amd-radeon-rx-5500xt-phantom-gaming-oc/",
		null,
		null,
		"https://speedlogic.com.co/wp-content/uploads/2020/08/4085.png",
        "https://gpu.userbenchmark.com/AMD-RX-5500-XT/Rating/4060");
        
insert into gpu 
	values (3,"TARJETA GRÁFICA 8 GIGAS ASUS-RTX 2070 SUPER DUAL OC", 175, 8, 2698000,null,null,
		"https://speedlogic.com.co/producto/tarjeta-grafica-8-gigas-asus-rtx-2070-super-dual-oc/",
		null,
		null,
		"https://speedlogic.com.co/wp-content/uploads/2020/08/3199.4.png",
        "https://gpu.userbenchmark.com/Nvidia-GTX-1650/Rating/4039");
        
insert into gpu 
	values (4,"Tarjeta De Vídeo Asus GeForce Rtx 2080 8gb Ddr6 Dual Gaming", 250, 8, null, 3699000,null,
		null,
		"https://www.tauretcomputadores.com/product/tarjeta-de-video-asus-geforce-rtx-2080-8gb-ddr6-dual-gaming",
		null,
		"https://www.tauretcomputadores.com/images/products/Product_202009050950571920607541.png",
        "https://gpu.userbenchmark.com/Nvidia-RTX-2080/Rating/4026");
        
# HDD
delete from hdd;
insert into hdd 
	values (1,"DISCO DURO 1 TERA SATA III WESTERN DIGITAL CAVIER GREEN PULL", 0, 1000, 99, 150000,null,null,
		"https://speedlogic.com.co/producto/disco-duro-1-tera-sata-iii-western-digital-cavier-green-pull/",
		null,
		null,
		"https://speedlogic.com.co/wp-content/uploads/2020/09/7035.png",
        null);
        
insert into hdd
	values (2,"DISCO DURO 1 TERA SATA III SEAGATE BARRACUDA (64M-7200)", 0, 1000, 159, 209000,null,null,
		"https://speedlogic.com.co/producto/disco-duro-1-tera-sata-iii-seagate-barracuda-64m-7200/",
		null,
		null,
		"https://speedlogic.com.co/wp-content/uploads/2020/09/7009.png",
        "https://hdd.userbenchmark.com/Seagate-Barracuda-1TB-2016/Rating/3896");
        
insert into hdd 
	values (3,"DISCO DURO 4 TERAS SATA SEAGATE PULL CONSTELLATION ES.3 SED", 0, 4000, 520, 328000,null,null,
		"https://speedlogic.com.co/producto/disco-duro-4-teras-sata-seagate-pull-constellation-es-3-sed/",
		null,
		null,
		"https://speedlogic.com.co/wp-content/uploads/2020/09/7059.png",
        "https://hdd.userbenchmark.com/Seagate-Barracuda-1TB-2016/Rating/3896");
        
# MotherBoard
delete from motherboard;
insert into motherboard
	values (1,"BOARD ASUS H310M-E R2 0.Micro A.V.R Pciexp M2.2DDR4 IX", 0, 328000,null,null,
		"https://speedlogic.com.co/producto/board-asus-h310m-e-r2-0-micro-a-v-r-pciexp-m2-2ddr4-ix/",
		null,
		null,
		"https://speedlogic.com.co/wp-content/uploads/2020/10/33106.png",
        "https://www.userbenchmark.com/System/Asus-PRIME-H310M-E/85352");
        
insert into motherboard
	values (2,"BOARD ASUS A520M-K Micro 3,2 HDMIA V R Pciexp 2DDR4 RYZ", 0, 404000,null,null,
		"https://speedlogic.com.co/producto/board-asus-a520m-k-micro-32-hdmia-v-r-pciexp-2ddr4-ryz/",
		null,
		null,
		"https://speedlogic.com.co/wp-content/uploads/2020/10/34148.png",
        "https://www.userbenchmark.com/System/Asus-PRIME-A520M-K/200735");
        
insert into motherboard 
	values (3,"BOARD ASUS TUF B450M PLUS GAMING CROSS.A V R 4DDR4 RYZ", 0, 506000,null,null,
		"https://speedlogic.com.co/producto/board-asus-tuf-b450m-plus-gaming-cross-a-v-r-4ddr4-ryz/",
		null,
		null,
		"https://speedlogic.com.co/wp-content/uploads/2020/10/34075.2.png",
        "https://www.userbenchmark.com/System/Asus-PRIME-H310M-E-R20/95683");
        
insert into motherboard
	values (4,"Board Asus Rog Strix Z490 E Gaming", 0, null,1330000,null,
		null,
		"https://www.tauretcomputadores.com/product/board-asus-rog-strix-z490-e-gaming",
		null,
		"https://dlcdnimgs.asus.com/websites/global/products/tcymjbjbhzloect5/img/z490/kv/hero.png",
        "https://www.userbenchmark.com/System/Asus-PRIME-H310M-E-R20/95683");

# CPU
delete from cpu;
insert into cpu
	values (1,"Procesador Amd Ryzen 3 3200g 3.6ghz Vega 8", 65, 4, 3.6, null,470000,null,
		null,
		"https://www.tauretcomputadores.com/product/procesador-amd-ryzen-3-3200g-3-6ghz-vega-8",
		null,
		"https://www.tauretcomputadores.com/images/products/Product_202009021848261929662495.png",
        "https://cpu.userbenchmark.com/SpeedTest/824486/AMD-Ryzen-3-3200G-with-Radeon-Vega-Graphics");
        
insert into cpu 
	values (2,"Procesador Amd Ryzen 5 3600Xt 3ra Generación", 65, 6, 3.8, null,1250000,null,
		null,
		"https://www.tauretcomputadores.com/product/procesador-amd-ryzen-5-3600xt-3ra-generacion",
		null,
		"https://www.tauretcomputadores.com/images/products/Product_2020090218505042013122.png",
        "https://cpu.userbenchmark.com/SpeedTest/1211585/AMD-Ryzen-5-3600XT-6-Core-Processor");
        
insert into cpu 
	values (3,"Procesador Intel Core I7 10700 10th Generación Socket LGA 1200", 65, 8, 2.9, null,1999000,1685000,
		null,
		"https://www.tauretcomputadores.com/product/procesador-intel-core-i7-10700-10th-generacion-socket-lga-1200",
		"https://clonesyperifericos.com/comprar/procesador-intel-core-i7-10700/",
		"https://www.tauretcomputadores.com/images/products/Product_20201003111425418517433.png",
        "https://cpu.userbenchmark.com/Intel-Core-i7-10700/Rating/4077");
        
insert into cpu 
	values (4,"Procesador Amd Ryzen 9 3950X 3ra Generación", 105, 16, 3.5, null,3799000,3910000,
		null,
		"https://www.tauretcomputadores.com/product/procesador-amd-ryzen-9-3950x-3ra-generacion",
		"https://clonesyperifericos.com/comprar/procesador-amd-ryzen-9-3950x/",
		"https://www.tauretcomputadores.com/images/products/Product_202009021850182064674330.png",
        "https://cpu.userbenchmark.com/AMD-Ryzen-9-3950X/Rating/4057");

delete from ram;
INSERT INTO easypc.ram values(1,'DDR4 8G 3000MHz ADATA XPG SPECTRIX D41 RGB',0,8,240000,204000,null,240000,'https://speedlogic.com.co/producto/memoria-ram-ddr4-8g-3000mhz-adata-xpg-spectrix-d41-rgb/',null,'https://clonesyperifericos.com/comprar/memoria-ram-xpg-spectrix-d41-8gb-3000mhz-rgb/','https://speedlogic.com.co/wp-content/uploads/2020/09/5225.png',null);
INSERT INTO easypc.ram values(2,'DDR4 8G 3000 MHz CORSAIR VENGEANCE LPX',0,8,240000,200000,null,215000,'https://speedlogic.com.co/producto/memoria-para-pc-ddr4-8g-3000-mhz-corsair-vengeance-lpx-negra/',null,'https://clonesyperifericos.com/comprar/memoria-ram-corsair-vengeance-lpx-8gb-1x8gb-ddr4-3000mhz/','https://speedlogic.com.co/wp-content/uploads/2020/08/5096.png','https://ram.userbenchmark.com/Corsair-Vengeance-LPX-DDR4-3000-C15-2x8GB/Rating/3546');
INSERT INTO easypc.ram values(3,'DDR4 16G 3000MHz CORSAIR VENGEANCE RGB PRO NEGRA',0,16,240000,361000,null,561000,'https://speedlogic.com.co/producto/memoria-ram-ddr4-16g-3000mhz-corsair-vengeance-rgb-pro-negra/',null,'https://clonesyperifericos.com/comprar/memoria-dram-ddr4-a-3600-mhz-vengeance-rgb-pro/','https://speedlogic.com.co/wp-content/uploads/2020/09/5164.png',null);
INSERT INTO easypc.ram values(4,'DDR4 16G 3600MHz XPG SPECTRIX D60 RGB',0,16,28800,430000,null,504000,'https://speedlogic.com.co/producto/memoria-ram-ddr4-16g-3600mhz-xpg-spectrix-d60-rgb/',null,'https://clonesyperifericos.com/comprar/memoria-ram-adata-xpg-spectrix-d60g-ddr4-2x8gb-3200mhz/','https://speedlogic.com.co/wp-content/uploads/2020/09/5271.png',null);

delete from powersupply;
INSERT INTO easypc.powersupply values(1,'Thermaltake Smart 430w 80 Plus',430,null,null,225000,null,null,'https://clonesyperifericos.com/comprar/fuente-de-poder-thermlatake-smart-430w-80-plus/','https://www.computerevolution.com.co/wp-content/uploads/2020/09/fuente-smart-430-80plus-blanca-800x800.png');
INSERT INTO easypc.powersupply values(2,'CORSAIR CV650W 80 PLUS BRONZE',650,332000,null,null,'https://speedlogic.com.co/producto/fuente-corsair-cv650w-80-plus-bronze/',null,null,'https://speedlogic.com.co/wp-content/uploads/2020/09/14121.1.png');
INSERT INTO easypc.powersupply values(3,'Thermaltake 750w Smart Bx1 Rgb 80 Plus Bronce',750,null,475000,null,null,'https://tauretcomputadores.com/product/fuente-thermaltake-750w-smart-bx1-rgb-80-plus-bronce',null,'https://www.tauretcomputadores.com/images/products/Product_202009051126381955941516.png');
INSERT INTO easypc.powersupply values(4,'CORSAIR RM1000 80 PLUS GOLD MODULAR',1000,990000,null,null,'https://speedlogic.com.co/producto/fuente-corsair-rm1000-80-plus-gold-modular/',null,null,'https://speedlogic.com.co/wp-content/uploads/2020/09/14128.png');

delete from ssd;
INSERT INTO easypc.ssd values(1,'120GB PNY CS900',0,120,515,110000,null,null,'https://speedlogic.com.co/producto/disco-solido-ssd-120gb-pny-cs900/',null,null,'https://speedlogic.com.co/wp-content/uploads/2020/10/12076.png','https://ssd.userbenchmark.com/SpeedTest/175702/PNY-CS900-120GB-SSD');
INSERT INTO easypc.ssd values(2,'M2 NVMe 250GB CRUCIAL P2',0,250,2100,259000,null,null,'https://speedlogic.com.co/producto/disco-solido-m2-nvme-250gb-crucial-p2/',null,null,'https://speedlogic.com.co/wp-content/uploads/2020/08/13085.png','https://ssd.userbenchmark.com/SpeedTest/1239408/CT250P5SSD8');
INSERT INTO easypc.ssd values(3,'M2 NVMe 512GB XPG SPECTRIX S40G RGB',0,512,3500,433000,null,430000,'https://speedlogic.com.co/producto/disco-solido-m2-nvme-512gb-xpg-spectrix-s40g-rgb/',null,'https://clonesyperifericos.com/comprar/ssd-adata-xpg-gammix-s40g-m2-2280-512gb-rgb/','https://speedlogic.com.co/wp-content/uploads/2020/08/13071.png',null);
INSERT INTO easypc.ssd values(4,'NVMe 1TB XPG GAMMIX S50 5000 x 4400',0,1000,5000,1080000,null,null,'https://speedlogic.com.co/producto/disco-solido-m2-nvme-1tb-xpg-gammix-s50-5000-x-4400/',null,null,'https://speedlogic.com.co/wp-content/uploads/2020/09/13093.png','https://ssd.userbenchmark.com/SpeedTest/953258/NVMe-XPG-GAMMIX-S50');

delete from easypc.user;
insert into easypc.user values(1,"Invitado","$2a$10$P4egRIenJyO5P/XuaLcPHO9IpZ1EssYu1h0zhEyG.1DLvYClJurbm");

INSERT INTO build (id_build,id_user, id_motherboard, id_cpu, id_gpu, id_ram, id_cooling, id_powersupply, id_case, date )
	values (1,1 , 1 , 1 , 1 , 1 , 1 , 1 , 1, "2020-10-10" );

SET SQL_SAFE_UPDATES = 1;
