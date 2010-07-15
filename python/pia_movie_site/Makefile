DATADIR=data
TARGET=movie_titles.txt
TARGET2=$(TARGET).`date "+%Y%m%d"`

all: clean $(DATADIR) scrape extract postprocess


$(DATADIR):
	mkdir -p $(DATADIR)

scrape.sh: pia-eigaseikatsu.urls
	cat $< \
	| ./urlencode.py \
	| awk '{print "curl -s \""$$1"\" > $(DATADIR)/"$$2".html"}' \
	> $@

scrape: scrape.sh $(DATADIR)
	sh $<

extract.sh:
	ls $(DATADIR)/*.html | awk '{print "cat "$$1" | ./title_extractor.py >> $(TARGET)"}' > $@

extract: extract.sh
	touch $(TARGET)
	sh $<

postprocess:$(TARGET)
	cat $< | LANG=ja_JP.UTF-8 sort -u > $<.tmp
	mv $<.tmp $(TARGET2)

clean:
	rm -f scrape.sh
	rm -f extract.sh
	rm -rf $(DATADIR)
	rm -rf $(TARGET)
	rm -rf $(TARGET2)
