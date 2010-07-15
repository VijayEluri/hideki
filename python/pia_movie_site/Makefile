DATADIR=data
TARGET=movie_titles.txt

all: clean $(DATADIR) scrape extract


$(DATADIR):
	mkdir -p $(DATADIR)

scrape.sh: pia-eigaseikatsu.urls
	cat $< \
	| ./urlencode.py \
	| awk '{print "curl -s \""$$1"\" > $(DATADIR)/"$$2".html"}' \
	> $@

	#| awk '{print "wget -O $(DATADIR)/"$$2".html "$$1}' \

scrape: scrape.sh $(DATADIR)
	sh $<

extract.sh:
	ls $(DATADIR)/*.html | awk '{print "cat "$$1" | ./title_extractor.py >> $(TARGET)"}' > $@

extract: extract.sh
	touch $(TARGET)
	sh $<

$(TARGET).uniq:$(TARGET)
	cat $< | LANG=ja_JP.UTF-8 sort -u > $@

clean:
	rm -f scrape.sh
	rm -f extract.sh
	rm -rf $(DATADIR)
	rm -rf $(TARGET)
	rm -rf $(TARGET).uniq
