"""Lightweight def/use inventory paired with a JaCoCo report."""
import pathlib
import re
import sys
import xml.etree.ElementTree as ET

source_root, report = pathlib.Path(sys.argv[1]), pathlib.Path(sys.argv[2])
definitions = uses = 0
for path in source_root.rglob("*.java"):
    text = path.read_text(encoding="utf-8")
    definitions += len(re.findall(r"\b(?:int|long|double|String|Item)\s+\w+", text))
    uses += len(re.findall(r"\b\w+\s*[.(]", text))
ET.parse(str(report))
print({"definitions": definitions, "uses": uses, "jacoco_report": str(report)})
