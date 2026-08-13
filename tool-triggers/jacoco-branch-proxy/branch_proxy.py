"""Summarize JaCoCo branch counters as a branch-coverage proxy."""
import sys
import xml.etree.ElementTree as ET

root = ET.parse(sys.argv[1]).getroot()
counters = [node for node in root.findall("counter") if node.get("type") == "BRANCH"]
covered = sum(int(node.get("covered", "0")) for node in counters)
missed = sum(int(node.get("missed", "0")) for node in counters)
print({"covered": covered, "missed": missed, "ratio": covered / float(covered + missed or 1)})
